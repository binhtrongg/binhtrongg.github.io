package tech_shop.backend.repository;

import tech_shop.backend.database.ProductDatabase;
import tech_shop.backend.exception.NotFoundException;
import tech_shop.backend.model.Product;
import tech_shop.backend.utils.FileUtils;

import java.util.*;

public class ProductRepository {
    public List<Product> findAllProduct() {
        return ProductDatabase.products;
    }

    public Product findProductById(int id) {
            for (Product product : ProductDatabase.products) {
                if (product.getId() == id) {
                    return product;
                }
            }
        throw new NotFoundException("Không Có Sản Phẩm Nào Có Id "+id);
    }

    public List<Product> findProductByName(String name) {
        List<Product> list = new ArrayList<>();
        for (Product product : ProductDatabase.products) {
            if (product.getName().equalsIgnoreCase(name)) {
                list.add(product);
                return list;
            }
        }
        throw new NotFoundException("Không Có Sản Phẩm Nào Có Tên " + name);
    }

    public List<Product> findProductByPrice(int minPrice, int maxPrice) {
        List<Product> list = new ArrayList<>();
        if (minPrice>=maxPrice){
            System.out.println("Min Price Cần Nhỏ Hơn Max Price");
        }
        else {
            for (Product product:ProductDatabase.products) {
                if (product.getPrice()>=minPrice&&product.getPrice()<=maxPrice){
                    list.add(product);
                }
            }
        }
        return list;
    }

    public void addProduct(Product product) {
        findAllProduct().add(product);
        FileUtils.saveDataToFile("product.json",findAllProduct());
    }

    public void deleteProduct(int id) {
        findProductById(id);
        findAllProduct().removeIf(product ->product.getId()==id);
        FileUtils.saveDataToFile("product.json",findAllProduct());
    }

    public void updateProductQuantity(Product product, int quantity) {
        product.setQuantity(quantity);;
        FileUtils.saveDataToFile("product.json",findAllProduct());
    }
}
