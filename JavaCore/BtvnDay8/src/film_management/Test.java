package film_management;

import java.util.Scanner;

import static film_management.FilmRepository.movies;
import static film_management.FilmRepository.serials;

public class Test {
    public static void main(String[] args) {
        run();
    }
    public static void run() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;
        while (!isQuit) {
            showMenu();
            System.out.print("Nhập lựa chọn : ");
            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1: {
                    System.out.println("Danh Sach Film");
                    printFilm();
                    break;
                }
                case 2: {
                    System.out.println("nhập tên Film cần tìm : ");
                    String name = sc.nextLine();
                    Film.findbyName(name);
                    break;
                }
                case 3: {
                    isQuit = true;
                    break;
                }
            }
        }
    }
    public static void printFilm() {

        for (int i = 0; i < movies.length; i++) {
            System.out.println(movies[i]);
        }
        for (int j = 0; j < serials.length; j++) {
            System.out.println(serials[j]);
        }
    }

    public static void showMenu() {
        System.out.println("\n********* MENU *********");
        System.out.println("1 - In danh sách Film");
        System.out.println("2 - Tìm kiếm Film bằng tên");
        System.out.println("3 - Thoát\n");

    }
}
