package logic;

import entity.Subject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SubjectManagement {
    private List<Subject> subjects;

    public SubjectManagement() {
        this.subjects = new ArrayList<>();
    }

    public void inputInfo() {
        System.out.print("số lượng môn học muốn nhập : ");
        int subjectCount;
        do {
            try {
                subjectCount = new Scanner(System.in).nextInt();
                if (subjectCount > 0) {
                    break;
                }
                System.out.print("số lượng môn học cần lớn hơn 0;nhập lại : ");
            } catch (InputMismatchException e) {
                System.out.print("số lượng không hợp lệ;vui lòng nhập số : ");
            }
        } while (true);
        for (int i = 0; i < subjectCount; i++) {
            System.out.println("Nhập thông tin môn học thứ " + (i + 1));
            Subject subject = new Subject();
            subject.inputInfor();
            subjects.add(subject);
        }
        showInfor();
    }

    private void showInfor() {
        subjects.forEach(System.out::println);
    }

    public boolean isEmptyFactory() {
        return subjects.isEmpty();
    }

    public Subject findById(int subjectId) {
        for (Subject sj : subjects) {
            if (sj.getId() == subjectId) {
                return sj;
            }
        }
        return null;
    }
}
