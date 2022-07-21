package com.example.purchases.controller_rest;

import com.example.purchases.model.Buyer;
import com.example.purchases.model.Product;
import com.example.purchases.model.Purchase;
import com.example.purchases.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest/report")
public class ReportRestController {

    private final ReportService reportService;

    public ReportRestController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("purchasesLastWeek")
    public List<Purchase> purchasesLastWeek() {
        return reportService.purchasesLastWeek();
    }

    @GetMapping("bestsellerLastMonth")
    public Product bestsellerLastMonth() {
        return reportService.bestsellerLastMonth();
    }

    @GetMapping("bestbuyerLastYear")
    public Buyer bestbuyerLastYear() {
        return reportService.bestbuyerLastYear();
    }

    @GetMapping("bestsellerFor18YearOld")
    public Product bestsellerFor18YearOld() {
        return reportService.bestsellerFor18YearOld();
    }
}
