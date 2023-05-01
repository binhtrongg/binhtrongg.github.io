package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Scanner;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Person implements InputInfo{
    protected String name;
    protected String address;
    protected String phone;

    @Override
    public void inputInfo() {
        System.out.println("Nhập tên: ");
        this.setName(new Scanner(System.in).nextLine());

        System.out.println("Nhập địa chỉ: ");
        this.setAddress(new Scanner(System.in).nextLine());

        System.out.println("Nhập SĐT: ");
        this.setPhone(new Scanner(System.in).nextLine());
    }
}
