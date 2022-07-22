package com.example.purchases.service.impl;

import com.example.purchases.model.Product;
import com.example.purchases.repository.ProductRepository;
import com.example.purchases.service.ReportBestSellerFor18YearOldService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportBestSellerFor18YearOldServiceImpl implements ReportBestSellerFor18YearOldService {

    private final ProductRepository productRepository;

    public ReportBestSellerFor18YearOldServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> bestSellerFor18YearOld() {
        return productRepository.bestSellerFor18YearOld();
    }
}
