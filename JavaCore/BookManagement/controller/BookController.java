package BookManagement.controller;

import BookManagement.service.BookService;

import java.util.Scanner;

public class BookController {
    public BookService bookService=new BookService();
    public void run() {
        Scanner sc = new Scanner(System.in);

        int option = 0;
        boolean isQuit = false;

        while (!isQuit) {
            showMenu();

            System.out.print("Nhập lựa chọn : ");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1: {System.out.print("Nhập tiêu đề cần tìm : ");
                    String title=sc.nextLine();
                    bookService.findbytitle(title);
                    break;
                }
                case 2: {
                    System.out.println("nhập thể loại cần tìm : ");
                    String category=sc.nextLine();
                    bookService.findbyCategory(category);
                    break;
                }
                case 3: {
bookService.checkYear();
                    break;

                }
            }
        }
    }
    public static void showMenu() {
        System.out.println("\n********* MENU *********");
        System.out.println("1 - Tìm sách theo tên");
        System.out.println("2 - Tìm sách theo thể loại");
        System.out.println("3 - Các sách xuất bản trong năm nay");
        System.out.println("4 - Thoát\n");
    }
}