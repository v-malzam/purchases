package com.example.purchases.service.impl;

import com.example.purchases.model.Buyer;
import com.example.purchases.repository.BuyerRepository;
import com.example.purchases.service.ReportBestBuyerLastYearService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportBestBuyerLastYearServiceImpl implements ReportBestBuyerLastYearService {

    private final BuyerRepository buyerRepository;

    public ReportBestBuyerLastYearServiceImpl(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @Override
    public List<Buyer> bestBuyerLastYear() {
        LocalDate lastYear = LocalDate.now().minusYears(1L);
        return buyerRepository.bestBuyerLastYear(lastYear);
    }
}
