package logic_handel;

import entity.Customer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CustomerManagement {
    private static List<Customer> customers;

    public CustomerManagement() {
        this.customers = new ArrayList<>();
    }

    public void inputInfo() {
        System.out.println("Bạn muốn nhập bao nhiêu khách hàng: ");
        int cusNumber;
        do {
            try {
                cusNumber = new Scanner(System.in).nextInt();
                if (cusNumber > 0) break;
                System.out.println("Số lượng khách hàng phải lớn hơn 0. Vui lòng Nhp lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);

        for (int i = 0; i < cusNumber; i++) {
            Customer customer = new Customer();
            customer.inputInfo();
            customers.add(customer);
        }
        showCustomer();
    }

    public void showCustomer() {
        customers.forEach(System.out::println);
    }

    public static Customer findById(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id)
                return customers.get(i);
        }
        return null;
    }
}
