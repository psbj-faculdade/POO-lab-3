package com.example.pessoa.controller;

import com.example.pessoa.entity.Product;
import com.example.pessoa.service.ProductService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(service.saveProduct(product));
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> findAllProducts() {
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(service.getProducts());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(service.getProductById(id));
    }

    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(service.updateProduct(product));
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id, HttpServletResponse response) {
        service.deleteProduct(id);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
