public class ForLoopPractice {
    public static void main(String[] args) {
        System.out.println(repeatString("a"));
        System.out.println(repeatString1("a"));
        System.out.println(repeatString3("a", 5));
        System.out.println(getSum());
        System.out.println("the tich " + getVolume(3.5));
        printNumber();
    }

    //    bài 1
    public static String repeatString(String str) {
        String rs = "";
        for (int i = 1; i <= 10; i++) {
            rs += str;
        }
        return rs;
    }

    //    bài 2
    public static String repeatString1(String str) {
        String rs = str;
        for (int i = 1; i < 10; i++) {
            rs += "-"+str;
        }
        return rs;
    }

    //    bài 3
    public static String repeatString3(String str, int count) {
        String rs =str ;
        for (int i = 1; i < count; i++) {
            rs += "-"+str;
        }
        return rs;
    }

    //    bài 4
    public static int getSum() {
        int tong = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 5 == 0) {
                tong = tong + i;
            }
        }
        return tong;
    }

    //    bài5
    public static double getVolume(double r) {
        double volume = 4 / 3 * Math.PI * Math.pow(r, 3);
        return volume;
    }

    //    bai 6
    public static void printNumber() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i + " FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println(i + " Fizz");
            } else if (i % 5 == 0) {
                System.out.println(i + " Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
