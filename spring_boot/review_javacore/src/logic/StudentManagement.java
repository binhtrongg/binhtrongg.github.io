package logic;

import entity.Student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private List<Student> students;

    public StudentManagement(){
        this.students=new ArrayList<>();
    }

    public void inputInfo(){
        System.out.print("số lượng học sinh muốn nhập : ");
        int studentCount;
        do {
            try {
                studentCount=new Scanner(System.in).nextInt();
                if (studentCount>0){
                    break;
                }
                System.out.print("số lượng học sinh cần lớn hơn 0;nhập lại : ");
            } catch (InputMismatchException e) {
                System.out.print("số lượng không hợp lệ;vui lòng nhập số : ");
            }
        }while (true);
        for (int i = 0; i <studentCount ; i++) {
            System.out.println("Nhập thông tin học sinh thứ "+(i+1));
            Student student=new Student();
            student.inputInfor();
            students.add(student);
        }
        showInfor();
    }
    public void showInfor(){
        students.forEach(System.out::println);
    }

    public boolean isEmptyWorker() {
        return students.isEmpty();
    }

    public Student findById(int studentId) {
        for (Student std : students) {
            if (std.getId() == studentId) {
                return std;
            }
        }
        return null;
    }
}
