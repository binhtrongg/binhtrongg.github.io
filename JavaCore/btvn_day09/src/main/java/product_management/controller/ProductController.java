package product_management.controller;

import product_management.repository.ProductRepository;

import java.util.Scanner;

public class ProductController {
    public static void run() {
        ProductRepository productRepository = new ProductRepository();
        Scanner sc = new Scanner(System.in);

        int option = 0;
        boolean isQuit = false;

        while (!isQuit) {
            showMenu();

            System.out.print("Nhập lựa chọn : ");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1: {
                    System.out.println("Danh Sach San Pham : ");
                    ProductRepository.prinInfo();
                    break;
                }
                case 2: {
                    System.out.print("Nhap Ten San Pham : ");
                    String name = sc.nextLine();
                    System.out.println(productRepository.findByName(name));
                    ;
                    break;
                }
                case 3: {
                    System.out.println("nhập id :");
                    int id = Integer.parseInt(sc.nextLine());
                    productRepository.findById(id);

                    break;
                }
                case 4: {
                    System.out.println("Cac san pham co so luong duoi 5");
                    productRepository.findByCount();
                    break;
                }
                case 5: {
                    productRepository.findByPrice();
                    break;
                }
                case 6: {
                    isQuit=true;
                    break;
                }
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n********* MENU *********");
        System.out.println("1 - Xem danh sách sản phẩm");
        System.out.println("2 - Tìm sản phẩm theo tên");
        System.out.println("3 - Tìm sản phẩm theo id");
        System.out.println("4 - Tìm các sản phẩn có số lượng dưới 5");
        System.out.println("5 - Tìm sản phẩm theo muc giá");
        System.out.println("6 - Thoát\n");
    }
    public static void showMenu3(){
        System.out.println("1 - xoa san pham");
        System.out.println("2 - cap nhat so luong san pham");
        System.out.println("3 - quay lai menu");
    }
}

