import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("nhap so hang : ");
        int row=sc.nextInt();
        System.out.print("nhap so cot : ");
        int col=sc.nextInt();

        int[][] ar=new int[row][col];
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                System.out.print("phan tu tai vi tri ["+i+"]["+j+"] : ");
                ar[i][j]=sc.nextInt();
            }
        }
        System.out.println("mang vua nhap : ");
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                System.out.print(ar[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("cac phan tu thuoc duong cheo chinh : ");
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                if (i==j){
                    System.out.print(ar[i][j]+" ");
                }
            }
        }
        System.out.println("\ncộng 2 mảng :");
        System.out.println("nhập mảng 2");
        int[][] ar2=new int[row][col];
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                System.out.print("phan tu tai vi tri ["+i+"]["+j+"] : ");
                ar2[i][j]=sc.nextInt();
            }
        }
         int[][] tong2Mang=new int[row][col];
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                tong2Mang[i][j]=ar[i][j]+ar2[i][j];
            }
        }
        System.out.println("mảng sau khi cộng : ");
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(tong2Mang[i][j]+" ");
            }
            System.out.println();
        }

    }
}
