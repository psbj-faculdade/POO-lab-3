package com.example.pessoa.repository;

import com.example.pessoa.entity.Product;

import java.util.List;

public interface ProductRepository {
    Product save(Product product);
    Product findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
}


