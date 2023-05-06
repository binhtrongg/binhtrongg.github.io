package entity;

import java.util.Scanner;

public class Student extends Person{
    private static int autoId=10000;
    private int id;
    private String className;

    public Student() {
        this.id=++autoId;
    }

    public Student(String name, String address, String phoneNumber) {
        super(name, address, phoneNumber);
    }

    public Student(int id, String className) {
        this.id = id;
        this.className = className;
    }

    public Student(String name, String address, String phoneNumber, int id, String className) {
        super(name, address, phoneNumber);
        this.id = id;
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", className='" + className + '\'' +
                '}';
    }

    @Override
    public void inputInfor() {
        super.inputInfor();
        System.out.print("Nhập Tên Lớp Học : ");
        this.className=new Scanner(System.in).nextLine();
    }
}
