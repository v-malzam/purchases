package com.example.purchases.service.impl;

import com.example.purchases.model.Product;
import com.example.purchases.repository.ProductRepository;
import com.example.purchases.service.ReportBestSellerLastMonthService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportBestSellerLastMonthServiceImpl implements ReportBestSellerLastMonthService {

    private final ProductRepository productRepository;

    public ReportBestSellerLastMonthServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> bestSellerLastMonth() {
        LocalDate lastMonth = LocalDate.now().minusMonths(1L);
        return productRepository.bestSellerLastMonth(lastMonth);
    }
}
