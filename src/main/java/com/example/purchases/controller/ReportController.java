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

    private final ReportBestBuyerLastYearService reportBestBuyerLastYearService;
    private final ReportBestSellerLastMonthService reportBestSellerLastMonthService;
    private final ReportBestSellerFor18YearOldService reportBestSellerFor18YearOldService;
    private final ReportPurchasesLastWeekService reportPurchasesLastWeekService;

    public ReportController(ReportBestBuyerLastYearService reportBestBuyerLastYearService,
                            ReportBestSellerLastMonthService reportBestSellerLastMonthService,
                            ReportBestSellerFor18YearOldService reportBestSellerFor18YearOldService,
                            ReportPurchasesLastWeekService reportPurchasesLastWeekService) {
        this.reportBestBuyerLastYearService = reportBestBuyerLastYearService;
        this.reportBestSellerLastMonthService = reportBestSellerLastMonthService;
        this.reportBestSellerFor18YearOldService = reportBestSellerFor18YearOldService;
        this.reportPurchasesLastWeekService = reportPurchasesLastWeekService;
    }

    @GetMapping
    public String report(Model model) {
        model.addAttribute("bestBuyerLastYear", reportBestBuyerLastYearService.bestBuyerLastYear());
        model.addAttribute("bestSellerLastMonth", reportBestSellerLastMonthService.bestSellerLastMonth());
        model.addAttribute("bestSellerFor18YearOld", reportBestSellerFor18YearOldService.bestSellerFor18YearOld());
        model.addAttribute("purchasesLastWeek", reportPurchasesLastWeekService.purchasesLastWeek());
        return "report/view";
    }

}
