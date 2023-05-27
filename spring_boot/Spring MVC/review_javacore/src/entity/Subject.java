package entity;

import statics.SubjectType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Subject implements InputInfor{
    private static int autoId=100;
    private int id;
    private String name;
    private int unit;

    private SubjectType subjectType;

    public Subject() {
        this.id=++autoId;
    }

    public Subject(int id, String name, int unit) {
        this.id = id;
        this.name = name;
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unit=" + unit +
                ", subjectType=" + subjectType +
                '}';
    }

    @Override
    public void inputInfor() {
        System.out.print("Nhập Tên Môn Học : ");
        this.name=new Scanner(System.in).nextLine();
        System.out.print("Nhập Số Đơn Vị Học Trình : ");
        do {
            try {
                this.unit=new Scanner(System.in).nextInt();
                if (this.unit>0){
                    break;
                }
                System.out.print("số đơn vị cần lớn hơn 0;nhập lại :");
            }
            catch (InputMismatchException e){
                System.out.print("số đơn vị không hợp lệ,Nhập lại : ");
            }
        }while (true);
        System.out.println("Chọn Loại Môn Học");
        System.out.println("1.Đại Cương");
        System.out.println("2.Cơ Sở Ngành");
        System.out.println("3.Chuyên Ngành");
        int choice;
        do {
            try {
                System.out.print("Lựa Chọn Của Bạn :");
                choice =new Scanner(System.in).nextInt();
                if (choice>=1&&choice<=3){
                    break;
                }
                System.out.println("Lựa chọn không hợp lệ");
            }
            catch (InputMismatchException e){
                System.out.println("Vui lòng Nhập Số từ 1 đến 3");
            }
        }
        while (true);
        switch (choice){
            case 1:{
                this.setSubjectType(SubjectType.ĐẠI_CƯƠNG);
                break;
            }
            case 2:{
                this.setSubjectType(SubjectType.CƠ_SỞ_NGÀNH);
                break;
            }
            case 3:{
                this.setSubjectType(SubjectType.CHUYÊN_NGÀNH);
                break;
            }
        }
    }
}
