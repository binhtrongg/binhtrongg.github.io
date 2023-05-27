package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@Data

@AllArgsConstructor
public class Service {
    private int id;
    private String name;
    private double price;
    private String unit;

    private static int AUTO_ID = 100;

    public Service() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public void inputInfo() {
        System.out.println("Nhập tên: ");
        this.setName(new Scanner(System.in).nextLine());

        System.out.println("Nhập giá: ");
        this.setPrice(new Scanner(System.in).nextDouble());

        System.out.println("Nhập đơn vị tính: ");
        this.setUnit(new Scanner(System.in).nextLine());
    }
}
