package com.example.mvctest.service;
import com.example.mvctest.entity.Product;
import com.example.mvctest.model.request.ProductRequest;
import com.example.mvctest.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    ObjectMapper objectMapper;

    ProductRepository productRepository;

    ProductStorageImgService productStorageImgService;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public String uploadAvatar(MultipartFile multipartFile){
        return productStorageImgService.upload(multipartFile);
    }

    public void saveProduct(ProductRequest productRequest) {
        Product product=objectMapper.convertValue(productRequest,Product.class);
        productRepository.save(product);
    }

    public Product findById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    public void updateProduct(ProductRequest productRequest) {
        Product product=objectMapper.convertValue(productRequest,Product.class);
        productRepository.save(product);
    }
}
