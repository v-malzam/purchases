package com.example.purchases.controller;

import com.example.purchases.model.Purchase;
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

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }


    @GetMapping
    public String getAll(Model model) {
        model.addAttribute(purchaseService.getAll());
        return "purchases";
    }

    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute(new Purchase());
        return "purchase/add";
    }

    @PostMapping("add")
    public String add(Purchase purchase, BindingResult result) {
        if (!result.hasErrors()) {
            purchaseService.create(purchase);
            return "redirect:/purchases";
        } else {
            return "redirect:/purchase/add";
        }
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute(purchaseService.getById(id));
        return "purchase/edit";
    }

    @PostMapping("edit")
    public String edit(Purchase purchase, BindingResult result) {
        if (!result.hasErrors()) {
            purchaseService.update(purchase);
            return "redirect:/purchases";
        } else {
            return "redirect:/purchase/edit";
        }
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        purchaseService.deleteById(id);
        return "redirect:/purchases";
    }
}
