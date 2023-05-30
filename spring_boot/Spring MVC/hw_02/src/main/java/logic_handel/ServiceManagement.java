package logic_handel;
import entity.Service;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ServiceManagement {

    private List<Service> services;

    public ServiceManagement() {
        this.services = new ArrayList<>();
    }

    public void inputInfo() {
        System.out.println("Bạn muốn nhập bao nhiêu dịch vụ: ");
        int serviceNumber;
        do {
            try {
                serviceNumber = new Scanner(System.in).nextInt();
                if (serviceNumber > 0) break;
                System.out.println("Số lượng hóa đơn phải lớn hơn 0. Vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
        for (int i = 0; i < serviceNumber; i++) {
            Service service = new Service();
            service.inputInfo();
            services.add(service);
        }
        showClient();
    }

    private void showClient() {
        services.forEach(System.out::println);
    }

    public Service findById(int id) {
        for (Service service : services) {
            if (service.getId() == id)
                return service;
        }
        return null;
    }
}
