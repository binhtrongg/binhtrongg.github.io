package tech_shop.backend.database;

import tech_shop.backend.model.Product;
import tech_shop.backend.utils.FileUtils;

import javax.swing.text.Utilities;
import java.util.List;

public class ProductDatabase {
    public static List<Product>products= FileUtils.getProductFromFile("product.json");
}
