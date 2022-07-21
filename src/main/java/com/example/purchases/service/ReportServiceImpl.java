package com.example.purchases.service;

import com.example.purchases.model.Buyer;
import com.example.purchases.model.Product;
import com.example.purchases.model.Purchase;
import com.example.purchases.repository.BuyerRepository;
import com.example.purchases.repository.ProductRepository;
import com.example.purchases.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final PurchaseRepository purchaseRepository;
    private final ProductRepository productRepository;
    private final BuyerRepository buyerRepository;

    public ReportServiceImpl(PurchaseRepository purchaseRepository, ProductRepository productRepository, BuyerRepository buyerRepository) {
        this.purchaseRepository = purchaseRepository;
        this.productRepository = productRepository;
        this.buyerRepository = buyerRepository;
    }

    @Override
    public List<Purchase> purchasesLastWeek() {
        LocalDate lastWeek = LocalDate.now().minusDays(7L);
        return purchaseRepository.recentPurchases(lastWeek);
    }

    @Override
    public Product bestsellerLastMonth() {
        LocalDate lastMonth = LocalDate.now().minusMonths(1L);
        return productRepository.bestSellerLastMonth(lastMonth);
    }

    @Override
    public Buyer bestbuyerLastYear() {
        LocalDate lastYear = LocalDate.now().minusYears(1L);
        return buyerRepository.bestBuyerLastYear(lastYear);
    }

    @Override
    public Product bestsellerFor18YearOld() {
        return productRepository.bestSellerFor18YearOld();
    }
}
