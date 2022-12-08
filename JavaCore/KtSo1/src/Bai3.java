import java.util.Random;

public class Bai3 {
    public static void main(String[] args) {
        Random n = new Random();
        System.out.println(n.nextInt());
        System.out.println(isPrimeNumber(n.nextInt()));

    }
    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
