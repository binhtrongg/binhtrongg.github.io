import java.util.Scanner;

public class BaiTapVeNhaDay4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhập chuỗi : ");
        String str = sc.nextLine();
        System.out.println("chuỗi trước khi chuẩn hóa : " + str);


        String[] array = str.split(" ");
        String chuanHoa = "";


        for (int i = 0; i < array.length; i++) {
            String chaR = "";
            if (array[i].length() != 0) {
                chaR += Character.toUpperCase(array[i].charAt(0));
                if (array[i].length() > 1)
                    chaR += array[i].substring(1);
                chuanHoa += chaR + " ";
            }
        }
        if (chuanHoa.charAt(chuanHoa.length()-1)== ' '){
            chuanHoa+="\b";
        }
        System.out.println("chuỗi sau khi chuẩn hóa : " + chuanHoa);

    }
}
