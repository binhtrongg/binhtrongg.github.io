import java.util.Scanner;

public class ScannerPractice {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("mời nhập chuỗi: ");
        String XinChao = sc.nextLine();
        System.out.println("chuỗi in hoa của chuỗi "+"\""+XinChao+"\"" +"là : "+XinChao.toUpperCase());
        System.out.println("chuỗi in thường của chuỗi "+"\""+XinChao+"\""+"là : "+XinChao.toLowerCase());
        System.out.println("số kí tự của chuỗi "+"\""+XinChao+"\""+"là : "+XinChao.length());
        System.out.println("kí tự của chuỗi "+"\""+XinChao+"\""+"là : "+XinChao.charAt(15));
        System.out.println("5 kí tự đầu tiên của chuỗi "+"\""+XinChao+"\""+"là : "+XinChao.substring(0,5));
        System.out.println("chuỗi "+"\""+XinChao+"\""+"có chứa chuỗi hello hay không : "+XinChao.contains("hello"));
    }
}
