import java.util.Scanner;

public class gioiThieuBanThan {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("nhập tên của bạn: ");
        String name= sc.nextLine();
        System.out.print("nhập tuổi của bạn: ");
        int age= Integer.parseInt(sc.nextLine());
        System.out.print("nhập giới tính của bạn: ");
        String GioiTinh=sc.nextLine();
        System.out.print("nhập địa chỉ của bạn: ");
        String DiaChi=sc.nextLine();
        System.out.println("Xin chào các bạn, mình tên là "+name+",năm nay mình "+age+" tuổi, giới tính "+GioiTinh+". Hiện tại mình đang sống và làm việc tại "+DiaChi);
    }
}
