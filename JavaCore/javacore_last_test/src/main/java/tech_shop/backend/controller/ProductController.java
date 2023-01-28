package tech_shop.backend.controller;

import tech_shop.backend.model.Product;
import tech_shop.backend.request.CreatProductRequest;
import tech_shop.backend.service.ProductSerVice;

import java.util.List;

public class ProductController {
    static final ProductSerVice productServie=new ProductSerVice();
    public List<Product> products() {
        return productServie.products();
    }

    public Product findProductById(int id) {
        return productServie.findProductByID(id);
    }

    public List<Product> findProDuctByName(String name) {
        return productServie.findProductByName(name);
    }
    public List<Product> findProductByPrice(int minPrice, int maxPrice) {
        return productServie.findProductByProce(minPrice,maxPrice);
    }

    public void creatProduct9(CreatProductRequest creatProductRequest) {
        productServie.creatProduct(creatProductRequest);
    }

    public void deleteProduct(int id) {
        productServie.deleteProduct(id);
    }

    public void updateProductQuantity(int id, int quantity) {
        productServie.updateProductQuantity(id,quantity);
    }

    public void updatePrice(int id, int price) {
        productServie.updatePrice(id,price);
    }
}
