package com.example.purchases.controller;

import com.example.purchases.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public String report(Model model) {
        model.addAttribute("bestBuyerLastYear", reportService.bestBuyerLastYear());
        model.addAttribute("bestSellerLastMonth", reportService.bestSellerLastMonth());
        model.addAttribute("bestSellerFor18YearOld", reportService.bestSellerFor18YearOld());
        model.addAttribute("purchasesLastWeek", reportService.purchasesLastWeek());
        return "report/view";
    }

}
