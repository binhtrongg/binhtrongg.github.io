import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String checkEmail="^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        String checkSdt="^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        System.out.println("nhap SDT : ");
        String sdt=sc.nextLine();
        System.out.println("nhap EMAIL : ");
        String email=sc.nextLine();

        System.out.println(sdt+": "+Pattern.matches(checkSdt,sdt));
        System.out.println(email+": "+Pattern.matches(checkEmail,email));
    }
}
