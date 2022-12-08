public class Bai4 {
    public static void main(String[] args) {
        int n=10;
        System.out.println(n+ " số nguyên tố đầu tiên là");
        int soNT=0;
        int i=0;
        while (soNT < n) {
            if (isPrimeNumber(i)) {
                System.out.print(i + " ");
                soNT++;
            }
            i++;
        }
        System.out.println("\nso nguyen to nho hơn "+n+" là :");
        if (n >= 2) {
            System.out.print(2);
        }
        for (int j = 3; j < n; j+=2) {
            if (isPrimeNumber(j)) {
                System.out.print(" " + j);
            }
        }
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
