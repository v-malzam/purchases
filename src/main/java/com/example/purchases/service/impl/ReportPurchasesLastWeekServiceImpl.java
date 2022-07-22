package com.example.purchases.service.impl;

import com.example.purchases.model.Purchase;
import com.example.purchases.repository.PurchaseRepository;
import com.example.purchases.service.ReportPurchasesLastWeekService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportPurchasesLastWeekServiceImpl implements ReportPurchasesLastWeekService {

    private final PurchaseRepository purchaseRepository;

    public ReportPurchasesLastWeekServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public List<Purchase> purchasesLastWeek() {
        LocalDate lastWeek = LocalDate.now().minusDays(7L);
        return purchaseRepository.recentPurchases(lastWeek);
    }
}
