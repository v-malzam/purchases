package com.example.purchases.service;

import com.example.purchases.model.Buyer;
import com.example.purchases.model.Product;
import com.example.purchases.model.Purchase;
import com.example.purchases.repository.ProductRepository;
import com.example.purchases.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final PurchaseRepository purchaseRepository;
    private final ProductRepository productRepository;

    public ReportServiceImpl(PurchaseRepository purchaseRepository, ProductRepository productRepository) {
        this.purchaseRepository = purchaseRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Purchase> purchasesLastWeek() {
        LocalDate lastWeek = LocalDate.now().minusDays(7L);
        return purchaseRepository.purchasesLastWeek(lastWeek);
    }

    @Override
    public LinkedHashMap<Integer, Product> bestsellerLastMonth() {
        LocalDate lastMonth = LocalDate.now().minusMonths(1L);
        return productRepository.bestSellerLastMonth(lastMonth);
    }

    @Override
    public LinkedHashMap<Integer, Buyer> bestbuyerLastYear() {
        LocalDate lastYear = LocalDate.now().minusYears(1L);
        return purchaseRepository.bestBuyerLastYear(lastYear);
    }

    @Override
    public LinkedHashMap<Integer, Product> bestsellerFor18YearOld() {
        return purchaseRepository.bestSellerFor18YearOld();
    }
}
