package product_management.database;

import product_management.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDB {

   public static ArrayList<Product> productArrayList=new ArrayList<>(List.of(
            new Product(1,"nuoc hoa","thơm",7,500_000),
            new Product(2,"bột giặt","ngon",3,40_000),
            new Product(3,"kem đánh răng","ngọt",2,110_000),
            new Product(4,"sạc dự phòng","khét",20,90_000),
            new Product(5,"tai nghe","rè",10,60_000)
    ));
}
