package logic;

import entity.Score;
import entity.ScoreDetail;
import entity.Student;
import entity.Subject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ScoreManagement {
    private List<Score>scores;
    private StudentManagement studentManagement;
    private SubjectManagement subjectManagement;

    public ScoreManagement(StudentManagement studentManagement,SubjectManagement subjectManagement){
        this.scores=new ArrayList<>();
        this.studentManagement=studentManagement;
        this.subjectManagement=subjectManagement;
    }

    public void addScore() {
        if (studentManagement.isEmptyWorker() || subjectManagement.isEmptyFactory()) {
            System.out.println("Cần nhập danh sách học sinh và môn học trước khi vào điểm");
            return;
        }
        System.out.print("số học sinh muốn nhập điểm : ");
        int studentNumber;
        do {
            try {
                studentNumber = new Scanner(System.in).nextInt();
                if (studentNumber > 0) {
                    break;
                }
                System.out.print("Số lượng học sinh nhập vào phải lơn hơn 0, nhập lại : ");
            } catch (InputMismatchException ex) {
                System.out.print("Vui lòng nhập số : ");
            }
        } while (true);

        for (int i = 0; i < studentNumber; i++) {
            System.out.print("Nhập ID của học sinh thứ " + (i + 1) + " mà bạn muốn vào điểm : ");
            int studentId;
            Student student;
            do {
                try {
                    studentId = new Scanner(System.in).nextInt();
                    student = studentManagement.findById(studentId);
                    if (student != null) {
                        if (!iSameUser(studentId,scores)) {
                            break;
                        }
                        System.out.print("Học Sinh đã được chấm điểm trước đó, vui lòng nhập ID khác : ");
                    }else {
                        System.out.print("ID không tồn tại trong hệ thống, vui lòng nhập lại : ");
                    }
                } catch (InputMismatchException ex) {
                    System.out.print("Vui lòng nhập số : ");
                }
            } while (true);

            System.out.print("học sinh này học bao nhiêu môn : ");
            int subjectNumber;
            do {
                try {
                    subjectNumber = new Scanner(System.in).nextInt();
                    if (subjectNumber > 0) {
                        break;
                    }
                    System.out.print("Số lượng môn học nhập vào phải lơn hơn 0, nhập lại : ");
                } catch (InputMismatchException ex) {
                    System.out.print("Vui lòng nhập số : ");
                }
            } while (true);

            List<ScoreDetail> scoreDetails = new ArrayList<>();
            for (int j = 0; j < subjectNumber; j++) {
                System.out.print("Nhập mã môn học thứ " + (j + 1) + " mà học sinh này học : ");
                int subjectId;
                Subject subject;
                do {
                    try {
                        subjectId = new Scanner(System.in).nextInt();
                        subject = subjectManagement.findById(subjectId);
                        if (subject != null) {
                            if (!isSameScore(subjectId,scoreDetails)) {
                                break;
                            }
                            System.out.print("Môn học đã được chấm điểm trước đó, vui lòng nhập ID khác : ");
                        } else {
                            System.out.print("ID không tồn tại trong hệ thống, vui lòng nhập lại : ");
                        }
                    } catch (InputMismatchException ex) {
                        System.out.print("Vui lòng nhập số : ");
                    }
                } while (true);

                System.out.print("số điểm sinh viên đạt được ở môn học này : ");
                float score;
                do {
                    try {
                        score = new Scanner(System.in).nextFloat();
                        if (score >= 0&& score<=10) {
                            break;
                        }
                        System.out.print("thang điểm từ 0 đến 10, nhập lại : ");
                    } catch (InputMismatchException ex) {
                        System.out.print("Vui lòng nhập số: ");
                    }
                } while (true);
                ScoreDetail scoreDetail=new ScoreDetail(subject,score);
                scoreDetails.add(scoreDetail);
            }

            Score score=new Score(student,scoreDetails);
            scores.add(score);

        }
        showInfo();
    }

    private void showInfo() {
        scores.forEach(System.out::println);
    }

    public boolean iSameUser(int userId,List<Score> scores){
        for (Score score_n:scores) {
            if (score_n.getStudent().getId()==userId){
                return true;
            }
        }
        return false;
    }
    public boolean isSameScore(int subjectId,List<ScoreDetail> scoreDetails){
        for (ScoreDetail scoreDetail_n:scoreDetails) {
            if (scoreDetail_n.getSubject().getId()==subjectId){
                return true;
            }
        }
        return false;
    }

    public void sortMenu() {
        System.out.println("-------_SẮP XẾP BẢNG ĐIỂM--------");
        System.out.println("1. Sắp xếp theo họ tên sinh viên");
        System.out.println("2. Theo Tên Môn học");
        System.out.println("3. Quay lại menu chính");
        System.out.print("lựa chọn của bạn : ");
        int choice;
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if (choice >= 1 && choice <= 3) {
                    break;
                }
                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Vui lòng nhập số từ 1 tới 3: ");
            }
        } while (true);
        switch (choice) {
            case 1:
                sortByStudentName();
                showInfo();
                break;
            case 2:
                sortBySubjectName();
                showInfo();
                break;
            case 3:
                break;
        }
    }

    private void sortByStudentName() {
        this.scores.sort((std1,std2)->std1.getStudent().getName().compareToIgnoreCase(std2.getStudent().getName()));
    }
    private void sortBySubjectName(){
        this.scores.forEach(score->score.getScoreDetails()
                .sort((st1,std2)->st1.getSubject().getName().compareToIgnoreCase(std2.getSubject().getName())));
    }
    public void caculateScore(){
        if (this.scores.isEmpty()){
            System.out.println("hãy vào điểm trước");
        }
        scores.forEach(score -> {
            float totalScore=0;
            int allDVHT=0;
            List<ScoreDetail> scoreDetails=score.getScoreDetails();
            for (ScoreDetail scd:scoreDetails) {
                totalScore+=scd.getScore();
                allDVHT+=scd.getSubject().getUnit();
            }
            float avgScore= totalScore /allDVHT;
            System.out.println("điểm trung binh của học sinh "+score.getStudent().getName()+":"+avgScore);
        });
    }
}
