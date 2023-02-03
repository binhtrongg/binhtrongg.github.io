import java.util.Scanner;

public class menuHomeworkDay4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Khởi Tạo Mảng");
        System.out.print("Số phần tử của mảng : ");
        int arraylenght = sc.nextInt();
        int[] array = new int[arraylenght];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Nhập phần tử thứ " + i + " : ");
            array[i] = sc.nextInt();
        }
        System.out.println("Tạo mảng thành công");

        boolean count = false;
        int option;
        while (!count) {
            showMenu();
            System.out.print("Nhập lựa chọn của bạn : ");
            option = sc.nextInt();

            switch (option) {
                case 1: {
                    System.out.println("Mảng bạn vừa nhập : ");
                    for (int j : array) {
                        System.out.println(j);
                    }
                    break;
                }
                case 2: {
                    System.out.println("Mảng sau khi các số chẵn tăng lên 1 : ");
                    for (int j = 0; j < array.length; j++) {
                        if (array[j] % 2 == 0) {
                            array[j]++;
                        }
                        System.out.println(array[j]);
                    }
                }
                case 3: {
                    System.out.println("Bạn chọn thoát ; Tạm Biệt!!");
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
                }
            }
        }
    }


    static void showMenu() {
        System.out.println("\nMenuPro");
        System.out.println("1 - In mảng vừa nhập");
        System.out.println("2 - Thay đổi các phần tử là số chẵn trong mảng tăng lên 1 phần tử");
        System.out.println("3 - Thoát\n");
    }
}
