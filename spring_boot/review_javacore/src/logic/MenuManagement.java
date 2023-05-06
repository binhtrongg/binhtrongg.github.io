package logic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManagement {
    private StudentManagement studentManagement;
    private SubjectManagement subjectManagement;
    private ScoreManagement scoreManagement;

    public MenuManagement(){
        this.studentManagement=new StudentManagement();
        this.subjectManagement=new SubjectManagement();
        this.scoreManagement=new ScoreManagement(studentManagement,subjectManagement);
    }

    private void printMenu() {
        System.out.println("------------PHẦN MỀM QUẢN LÝ ĐIỂM HỌC SINH --------------");
        System.out.println("1. Nhập danh sách học sinh mới và in ra màn hình");
        System.out.println("2. Nhập danh sách môn học mới và in ra màn hình");
        System.out.println("3. Lập bảng điểm cho học sinh");
        System.out.println("4. Sắp xếp bảng điểm");
        System.out.println("5. Lập bảng điểm trung bình");
        System.out.println("6. Thoát");
        System.out.print("lựa chọn của bạn : ");
    }

    private int functionChoice() {
        int choice;
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if (choice >= 1 && choice <= 6) {
                    break;
                }
                System.out.print("Vui lòng nhập số từ 1 tới 6 : ");
            } catch (InputMismatchException ex) {
                System.out.print("lựa chọn không hợp lệ,vui lòng nhập lại : ");
            }
        } while (true);
        return choice;
    }

    public void menu() {
        while (true) {
            printMenu();
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    studentManagement.inputInfo();
                    break;
                case 2:
                    subjectManagement.inputInfo();
                    break;
                case 3:
                    scoreManagement.addScore();
                    break;
                case 4:
                    scoreManagement.sortMenu();
                    break;
                case 5:
                    scoreManagement.caculateScore();
                    break;
                case 6:
                    return;
            }
        }
    }
}
