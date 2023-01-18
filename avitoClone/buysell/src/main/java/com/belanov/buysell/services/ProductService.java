package com.belanov.buysell.services;

import com.belanov.buysell.models.Product;
import com.belanov.buysell.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> list(String title) {
        if(title !=null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    public void saveProduct(Product product) {

        productRepository.save(product);
        log.info("Saving new {}", product);
    }

    public void deleteProduct(Long id) {
        log.info("Deleting stuff with id={}",id);
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
