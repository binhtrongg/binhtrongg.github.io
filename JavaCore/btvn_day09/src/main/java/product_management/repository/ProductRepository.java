package product_management.repository;

import product_management.controller.ProductController;
import product_management.database.ProductDB;
import product_management.model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ProductRepository {
    Scanner sc = new Scanner(System.in);
    Iterator<Product> iterator = ProductDB.productArrayList.iterator();

    public static void prinInfo() {
        for (Product p : ProductDB.productArrayList) {
            System.out.println(p);
        }
    }

    public ArrayList<Product> findByName(String name) {
        ArrayList<Product> rs = new ArrayList<>();
        for (Product p : ProductDB.productArrayList) {
            if (p.getName().toLowerCase().contains(name)) {
                rs.add(p);
            }
        }
        return rs;
    }

    public void findById(int id) {
        for (Product p : ProductDB.productArrayList) {
            if (p.getId() == id) {
                System.out.println(p);
            }
        }
        boolean isQuit = false;
        while (!isQuit) {
            ProductController.showMenu3();
            Scanner sc = new Scanner(System.in);
            System.out.print("lua chon cua ban: ");
            int option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1: {
                    System.out.println("san pham da duoc xoa");
                    deleteById(id);
                    break;
                }
                case 2: {
                    System.out.println("so luong san pham muon cap nhat");
                    int updatecount=sc.nextInt();
                    updateCount(updatecount);
                    sc.nextLine();
                    break;
                }
                case 3: {
                    isQuit=true;
                    break;
                }
            }
        }
    }

    public void deleteById(int id) {
        while (iterator.hasNext()) {
            Product element = iterator.next();
            if (element.getId() == id) {
                iterator.remove();
            }
        }
    }
    public void updateCount(int count){
        for (Product p:ProductDB.productArrayList) {
            p.setQuantity(count);
        }
    }

    public void findByCount() {
        for (Product p : ProductDB.productArrayList) {
            if (p.getQuantity() < 5) {
                System.out.println(p);
            }
        }
    }

    public void findByPrice() {

        boolean isQuit = false;
        while (!isQuit) {
            showAllPrice();
            Scanner sc = new Scanner(System.in);
            System.out.print("lua chon cua ban: ");
            int option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1: {
                    for (Product product : ProductDB.productArrayList) {
                        if (product.getPrice() < 50_000) {
                            System.out.println("san pham duoi 50k");
                            System.out.println(product);
                        }
                    }
                    break;
                }
                case 2: {
                    for (Product product : ProductDB.productArrayList) {
                        if (product.getPrice() < 100_000 && product.getPrice() >= 50_000) {
                            System.out.println("san pham tu 50k-100k");
                            System.out.println(product);
                        }
                    }
                    break;
                }
                case 3: {
                    for (Product product : ProductDB.productArrayList) {
                        if (product.getPrice() > 100_000) {
                            System.out.println("san pham lon hon 100k");
                            System.out.println(product);
                        }
                    }
                    break;
                }
                case 4: {
                    isQuit = true;
                    System.out.println("Quay lại Menu chính");
                    break;
                }
            }
        }
    }

    public void showAllPrice() {
        System.out.println("1 -- Sản phẩm dưới 50.000");
        System.out.println("2 -- Sản phẩm từ 50.000 - 100.000");
        System.out.println("3 -- Sản phẩm trên 100.000");
        System.out.println("4 -- Quay lại Menu");
    }
}
