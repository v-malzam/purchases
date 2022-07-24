package com.example.purchases.service.impl;

import com.example.purchases.model.Buyer;
import com.example.purchases.repository.BuyerRepository;
import com.example.purchases.service.ReportBestBuyerLastYearService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReportBestBuyerLastYearServiceImpl implements ReportBestBuyerLastYearService {

    private final BuyerRepository buyerRepository;
    private final EntityManager entityManager;

    public ReportBestBuyerLastYearServiceImpl(BuyerRepository buyerRepository, EntityManager entityManager) {
        this.buyerRepository = buyerRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<Buyer> bestBuyerLastYear() {
        entityManager.clear();
        LocalDate lastYear = LocalDate.now().minusYears(1L);
        return buyerRepository.bestBuyerLastYear(lastYear);
    }
}
