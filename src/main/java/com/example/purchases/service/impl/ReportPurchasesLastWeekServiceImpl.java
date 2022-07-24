package com.example.purchases.service.impl;

import com.example.purchases.model.Purchase;
import com.example.purchases.repository.PurchaseRepository;
import com.example.purchases.service.ReportPurchasesLastWeekService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReportPurchasesLastWeekServiceImpl implements ReportPurchasesLastWeekService {

    private final PurchaseRepository purchaseRepository;
    private final EntityManager entityManager;

    public ReportPurchasesLastWeekServiceImpl(PurchaseRepository purchaseRepository, EntityManager entityManager) {
        this.purchaseRepository = purchaseRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<Purchase> purchasesLastWeek() {
        entityManager.clear();
        LocalDate lastWeek = LocalDate.now().minusDays(7L);
        return purchaseRepository.recentPurchases(lastWeek);
    }
}
