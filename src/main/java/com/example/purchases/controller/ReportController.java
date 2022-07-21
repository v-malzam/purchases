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

    @GetMapping("purchasesLastWeek")
    public String purchasesLastWeek(Model model) {
        model.addAttribute(reportService.purchasesLastWeek());
        return "purchasesLastWeek";
    }

    @GetMapping("bestsellerLastMonth")
    public String bestsellerLastMonth(Model model) {
        model.addAttribute(reportService.bestsellerLastMonth());
        return "bestsellerLastMonth";
    }

    @GetMapping("bestbuyerLastYear")
    public String bestbuyerLastYear(Model model) {
        model.addAttribute(reportService.bestbuyerLastYear());
        return "bestbuyerLastYear";
    }

    @GetMapping("bestsellerFor18YearOld")
    public String bestsellerFor18YearOld(Model model) {
        model.addAttribute(reportService.bestsellerFor18YearOld());
        return "bestsellerFor18YearOld";
    }
}
