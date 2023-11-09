package com.example.pessoa;

import com.example.pessoa.entity.Product;
import com.example.pessoa.repository.ProductRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private List<Product> products = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(idGenerator.incrementAndGet());
            products.add(product);
        } else {
            int index = -1;
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId().equals(product.getId())) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                products.set(index, product);
            } else {
                // Tratar o caso em que o produto não existe
                throw new RuntimeException("Produto não encontrado");
            }
        }
        return product;
    }

    @Override
    public Product findById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void deleteById(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}
