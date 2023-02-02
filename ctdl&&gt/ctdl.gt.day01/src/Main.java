import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] ar = new int[4];
        ar[0] = 1;
        ar[1] = 3;
        ar[2] = 5;
        for (int i = ar.length - 1; i > 1; i--) {
            ar[i] = ar[i - 1];
        }
        ar[1]=6;
        for (int i:ar){
            System.out.println(i);
        }
        System.out.println();
        for (int i = 1; i <ar.length-1; i++) {
            ar[i] = ar[i+1];
        }
        ar[3]=0;
        for (int i:ar){
            System.out.println(i);
        }
        System.out.println(Arrays.toString(ar));
    }
}