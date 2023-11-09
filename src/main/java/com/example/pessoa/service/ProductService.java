package com.example.pessoa.service;

import com.example.pessoa.entity.Product;
import com.example.pessoa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(Long id) {
        return repository.findById(id);
    }

    public String deleteProduct(Long id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId());
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }


}
