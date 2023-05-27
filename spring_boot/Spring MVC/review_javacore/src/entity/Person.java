package entity;

import java.util.Scanner;

public class Person implements InputInfor {
    protected String name;
    protected String address;
    protected String phoneNumber;

    public Person() {
    }

    public Person(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public void inputInfor() {
            System.out.print("Nhập Tên : ");
            this.name=new Scanner(System.in).nextLine();
            System.out.print("Nhập Địa Chỉ : ");
            this.address=new Scanner(System.in).nextLine();
            System.out.print("Nhập Số Điện Thoại : ");
            this.phoneNumber=new Scanner(System.in).nextLine();
    }
}
