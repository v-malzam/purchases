package com.example.purchases.service.impl;

import com.example.purchases.model.Product;
import com.example.purchases.repository.ProductRepository;
import com.example.purchases.service.ReportBestSellerLastMonthService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReportBestSellerLastMonthServiceImpl implements ReportBestSellerLastMonthService {

    private final ProductRepository productRepository;
    private final EntityManager entityManager;

    public ReportBestSellerLastMonthServiceImpl(ProductRepository productRepository, EntityManager entityManager) {
        this.productRepository = productRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<Product> bestSellerLastMonth() {
        entityManager.clear();
        LocalDate lastMonth = LocalDate.now().minusMonths(1L);
        return productRepository.bestSellerLastMonth(lastMonth);
    }
}
