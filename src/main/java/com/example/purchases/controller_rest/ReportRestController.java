package com.example.purchases.controller_rest;

import com.example.purchases.model.Buyer;
import com.example.purchases.model.Product;
import com.example.purchases.model.Purchase;
import com.example.purchases.service.ReportBestBuyerLastYearService;
import com.example.purchases.service.ReportBestSellerFor18YearOldService;
import com.example.purchases.service.ReportBestSellerLastMonthService;
import com.example.purchases.service.ReportPurchasesLastWeekService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest/report")
public class ReportRestController {

    private final ReportPurchasesLastWeekService reportPurchasesLastWeekService;
    private final ReportBestSellerLastMonthService reportBestSellerLastMonthService;
    private final ReportBestBuyerLastYearService reportBestBuyerLastYearService;
    private final ReportBestSellerFor18YearOldService reportBestSellerFor18YearOldService;


    public ReportRestController(ReportPurchasesLastWeekService reportPurchasesLastWeekService,
                                ReportBestSellerLastMonthService reportBestSellerLastMonthService,
                                ReportBestBuyerLastYearService reportBestBuyerLastYearService,
                                ReportBestSellerFor18YearOldService reportBestSellerFor18YearOldService) {
        this.reportPurchasesLastWeekService = reportPurchasesLastWeekService;
        this.reportBestSellerLastMonthService = reportBestSellerLastMonthService;
        this.reportBestBuyerLastYearService = reportBestBuyerLastYearService;
        this.reportBestSellerFor18YearOldService = reportBestSellerFor18YearOldService;
    }

    @GetMapping("purchasesLastWeek")
    public List<Purchase> purchasesLastWeek() {
        return reportPurchasesLastWeekService.purchasesLastWeek();
    }

    @GetMapping("bestSellerLastMonth")
    public List<Product> bestSellerLastMonth() {
        return reportBestSellerLastMonthService.bestSellerLastMonth();
    }

    @GetMapping("bestBuyerLastYear")
    public List<Buyer> bestBuyerLastYear() {
        return reportBestBuyerLastYearService.bestBuyerLastYear();
    }

    @GetMapping("bestSellerFor18YearOld")
    public List<Product> bestSellerFor18YearOld() {
        return reportBestSellerFor18YearOldService.bestSellerFor18YearOld();
    }
}
