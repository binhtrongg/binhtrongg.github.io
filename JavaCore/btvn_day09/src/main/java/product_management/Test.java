package product_management;

import product_management.controller.ProductController;
import product_management.database.ProductDB;
import product_management.repository.ProductRepository;

public class Test {
   public static void main(String[] args) {
       ProductController productController=new ProductController();
       ProductController.run();
    }
}
