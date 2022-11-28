import java.util.Scanner;

public class hinhchunhat {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("nhập chiều dài của hình chữ nhật: ");
         int chieuDai= sc.nextInt();
        System.out.print("nhập chiều rộng ca hình chữ nhật: ");
        int chieuRong=sc.nextInt();

        int chuVi= (chieuDai+chieuRong)*2;
        int dienTich=(chieuDai*chieuRong);
        System.out.println("chu vi của hình chữ nhật là: "+chuVi);
        System.out.println("diện tích của hình chữ nhật là: "+dienTich);
    }
}
