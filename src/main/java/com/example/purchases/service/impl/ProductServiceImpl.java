package com.example.purchases.service.impl;

import com.example.purchases.model.Product;
import com.example.purchases.repository.ProductRepository;
import com.example.purchases.service.ProductService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final EntityManager entityManager;

    public ProductServiceImpl(ProductRepository productRepository, EntityManager entityManager) {
        this.productRepository = productRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<Product> getAll() {
        entityManager.clear();
        return productRepository.findAll();
    }

}
