package com.example.mvctest.controller;
import com.example.mvctest.model.request.ProductRequest;
import com.example.mvctest.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping
@AllArgsConstructor
public class ProductController {
    ProductService productService;

    @PostMapping("/api/v1/products/avatar")
    public ResponseEntity<?> uploadAvatar(@RequestParam("avatar") MultipartFile avatar){
        String url = productService.uploadAvatar(avatar);
        return ResponseEntity.ok(url);
    }

    @PostMapping("api/v1/products")
    public String saveProducts(@ModelAttribute("newProduct") ProductRequest productRequest){
        productService.saveProduct(productRequest);
        return "redirect:/admin/products";
    }

    @GetMapping("/api/v1/products/{id}")
    public ResponseEntity<?> getCurProduct(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PutMapping("/api/v1/products/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") Integer id,@RequestBody ProductRequest productRequest){
        productRequest.setId(id);
        productService.updateProduct(productRequest);
        return ResponseEntity.ok(null);
    }

}
