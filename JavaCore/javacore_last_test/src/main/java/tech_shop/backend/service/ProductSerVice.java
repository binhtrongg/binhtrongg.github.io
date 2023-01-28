package tech_shop.backend.service;

import tech_shop.backend.model.Product;
import tech_shop.backend.repository.ProductRepository;
import tech_shop.backend.request.CreatProductRequest;

import java.util.List;

public class ProductSerVice {
    static final ProductRepository productRepository=new ProductRepository();
    public List<Product> products() {
        return productRepository.findAllProduct();
    }

    public Product findProductByID(int id) {
        return productRepository.findProductById(id);
    }

    public List<Product> findProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    public List<Product> findProductByProce(int minPrice, int maxPrice) {
        return productRepository.findProductByPrice(minPrice,maxPrice);
    }

    public Product creatProduct(CreatProductRequest creatProductRequest) {
        Product product=new Product();
        product.setId(products().get(products().size()-1).getId()+1);
        product.setName(creatProductRequest.getName());
        product.setBrand(creatProductRequest.getBrand());
        product.setQuantity(creatProductRequest.getQuantity());
        product.setPrice(creatProductRequest.getPrice());
        productRepository.addProduct(product);
        return product;
    }

    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }

    public void updateProductQuantity(int id, int quantity) {
        Product product=findProductByID(id);
        productRepository.updateProductQuantity(product,quantity);
    }

    public void updatePrice(int id, int price) {
        Product product=findProductByID(id);
        productRepository.updatePrice(product,price);
    }
}
