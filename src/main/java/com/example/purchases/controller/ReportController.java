package com.example.purchases.controller;

import com.example.purchases.service.ReportBestBuyerLastYearService;
import com.example.purchases.service.ReportBestSellerFor18YearOldService;
import com.example.purchases.service.ReportBestSellerLastMonthService;
import com.example.purchases.service.ReportPurchasesLastWeekService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("report")
public class ReportController {

    private final ReportPurchasesLastWeekService reportPurchasesLastWeekService;
    private final ReportBestSellerLastMonthService reportBestSellerLastMonthService;
    private final ReportBestBuyerLastYearService reportBestBuyerLastYearService;
    private final ReportBestSellerFor18YearOldService reportBestSellerFor18YearOldService;

    public ReportController(ReportPurchasesLastWeekService reportPurchasesLastWeekService,
                            ReportBestSellerLastMonthService reportBestSellerLastMonthService,
                            ReportBestBuyerLastYearService reportBestBuyerLastYearService,
                            ReportBestSellerFor18YearOldService reportBestSellerFor18YearOldService) {
        this.reportPurchasesLastWeekService = reportPurchasesLastWeekService;
        this.reportBestSellerLastMonthService = reportBestSellerLastMonthService;
        this.reportBestBuyerLastYearService = reportBestBuyerLastYearService;
        this.reportBestSellerFor18YearOldService = reportBestSellerFor18YearOldService;
    }

    @GetMapping
    public String report(Model model) {
        model.addAttribute(reportPurchasesLastWeekService.purchasesLastWeek());
        model.addAttribute(reportBestSellerLastMonthService.bestSellerLastMonth());
        model.addAttribute(reportBestBuyerLastYearService.bestBuyerLastYear());
        model.addAttribute(reportBestSellerFor18YearOldService.bestSellerFor18YearOld());
        return "report/view";
    }
}
