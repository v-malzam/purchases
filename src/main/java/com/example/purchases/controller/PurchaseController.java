package com.example.purchases.controller;

import com.example.purchases.model.Purchase;
import com.example.purchases.service.BuyerService;
import com.example.purchases.service.ProductService;
import com.example.purchases.service.PurchaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;
    private final BuyerService buyerService;
    private final ProductService productService;

    public PurchaseController(PurchaseService purchaseService, BuyerService buyerService, ProductService productService) {
        this.purchaseService = purchaseService;
        this.buyerService = buyerService;
        this.productService = productService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute(purchaseService.getAll());
        return "purchase/view";
    }

    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute(buyerService.getAll());
        model.addAttribute(productService.getAll());
        return "purchase/add";
    }

    @PostMapping("add")
    public String add(Purchase purchase, BindingResult result) {
        purchaseService.create(purchase);
        return "redirect:/purchase";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute(purchaseService.getById(id));
        model.addAttribute(buyerService.getAll());
        model.addAttribute(productService.getAll());
        return "purchase/edit";
    }

    @PostMapping("edit")
    public String edit(Purchase purchase, BindingResult result) {
        purchaseService.update(purchase);
        return "redirect:/purchase";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        purchaseService.deleteById(id);
        return "redirect:/purchase";
    }

}
