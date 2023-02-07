import day03.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
                new Student("tran binh trong", 18, 9),
                new Student("si tạ", 15, 7.5),
                new Student("ri con", 15, 6),
                new Student("đi bộ vuốt râu", 10, 9.5),
                new Student("trong em", 9, 2),
                new Student("trong binh tran", 3, 6)
        ));
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getName().equals(o2.getName())) {
                    return o1.getAge() - o2.getAge();
                }
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (Student std : students) {
            System.out.println(std);
        }
        System.out.println();
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getAge() == o2.getAge()) {
                    return (int) (o2.getGPA() - o1.getGPA());
                }
                return o1.getAge() - o2.getAge();
            }
        });
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().substring(o1.getName().lastIndexOf(" "))
                        .compareTo(o2.getName().substring(o2.getName().lastIndexOf(" ")));
            }
        });
        for (Student std : students) {
            System.out.println(std);
        }
    }
}