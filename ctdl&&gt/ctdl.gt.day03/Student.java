package day03;

public class Student implements Comparable {
    private String name;
    private int age;
    private double GPA;

    public Student(String name,int age,double GPA) {
        this.name = name;
        this.age=age;
        this.GPA=GPA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(int GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", GPA=" + GPA +
                '}';
    }

    @Override
    public int compareTo(Object other) {
        Student student=(Student)other;
        if (this.age>((Student) other).getAge()){
            return 1;
        }
        else if (this.age<((Student) other).getAge()){
            return -1;
        }
        else return 0;
    }
}
