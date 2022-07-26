package com.example.purchases.service.impl;

import com.example.purchases.model.Buyer;
import com.example.purchases.model.Product;
import com.example.purchases.model.Purchase;
import com.example.purchases.repository.BuyerRepository;
import com.example.purchases.repository.ProductRepository;
import com.example.purchases.repository.PurchaseRepository;
import com.example.purchases.service.ReportService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final BuyerRepository buyerRepository;
    private final ProductRepository productRepository;
    private final PurchaseRepository purchaseRepository;
    private final EntityManager entityManager;

    public ReportServiceImpl(BuyerRepository buyerRepository, ProductRepository productRepository,
                             PurchaseRepository purchaseRepository, EntityManager entityManager) {
        this.buyerRepository = buyerRepository;
        this.productRepository = productRepository;
        this.purchaseRepository = purchaseRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<Buyer> bestBuyerLastYear() {
        entityManager.clear();
        LocalDate lastYear = LocalDate.now().minusYears(1L);
        return buyerRepository.bestBuyerLastYear(lastYear);
    }

    @Override
    public List<Product> bestSellerFor18YearOld() {
        entityManager.clear();
        return productRepository.bestSellerFor18YearOld();
    }

    @Override
    public List<Product> bestSellerLastMonth() {
        entityManager.clear();
        LocalDate lastMonth = LocalDate.now().minusMonths(1L);
        return productRepository.bestSellerLastMonth(lastMonth);
    }

    @Override
    public List<Purchase> purchasesLastWeek() {
        entityManager.clear();
        LocalDate lastWeek = LocalDate.now().minusDays(7L);
        return purchaseRepository.recentPurchases(lastWeek);
    }

}
