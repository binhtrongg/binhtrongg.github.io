package logic_handel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManagement {
    private CustomerManagement customerManagement;
    private ServiceManagement serviceManagement;
    private BillManagement billManagement;

    public MenuManagement() {
        this.customerManagement = new CustomerManagement();
        this.serviceManagement = new ServiceManagement();
        this.billManagement = new BillManagement(customerManagement,serviceManagement);
    }

    public void menu() {
        while (true) {
            printMenu();
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1: {
                    customerManagement.inputInfo();
                    break;}
                case 2:{
                    serviceManagement.inputInfo();
                    break;}
                case 3:
                    billManagement.logBill();
                    break;
                case 4:
                    System.out.println("Sắp xếp theo tên");
                    billManagement.sortByName();

                    System.out.println("Sắp xếp theo số lượng giảm dần");
                    billManagement.sortBillsByServiceUsage();
                    break;
                case 5:
                    billManagement.calculateTotal();
                    break;
                case 6:
                    return;

            }
        }

    }

    private void printMenu() {
        System.out.println("---------PHẦN MỀM QUẢN LÝ KHÁCH HÀNG---------");
        System.out.println("1.Nhập danh sách khách hàng. In ra danh sách khách hàng đã có ");
        System.out.println("2. Nhập danh sách dịch vụ. In ra danh sách dịch vụ đã có");
        System.out.println("3. Nhập hóa đơn cho khách hàng");
        System.out.println("4. Sắp xếp danh sách hóa đơn");
        System.out.println("5. Lập bảng thống kê cho khách hàng");
        System.out.println("6. Thoát");
        System.out.print("Vui lòng chọn chức năng: ");
    }
    private int functionChoice() {
        int choice ;
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if (choice >= 1 && choice <=6) {
                    break;
                }
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Vui lòng nhập số từ 1 tới 6");
            }
        } while (true);
        return  choice;
    }
}
