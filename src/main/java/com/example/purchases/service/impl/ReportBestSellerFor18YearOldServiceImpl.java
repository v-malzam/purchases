package com.example.purchases.service.impl;

import com.example.purchases.model.Product;
import com.example.purchases.repository.ProductRepository;
import com.example.purchases.service.ReportBestSellerFor18YearOldService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ReportBestSellerFor18YearOldServiceImpl implements ReportBestSellerFor18YearOldService {

    private final ProductRepository productRepository;
    private final EntityManager entityManager;

    public ReportBestSellerFor18YearOldServiceImpl(ProductRepository productRepository, EntityManager entityManager) {
        this.productRepository = productRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<Product> bestSellerFor18YearOld() {
        entityManager.clear();
        return productRepository.bestSellerFor18YearOld();
    }
}
