package com.example.purchases.controller_rest;

import com.example.purchases.model.Purchase;
import com.example.purchases.model.PurchaseList;
import com.example.purchases.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/purchase")
public class PurchaseRestController {

    private final PurchaseService purchaseService;

    public PurchaseRestController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping(produces = {"text/xml", "application/xml"})
    public PurchaseList getAll() {
        return new PurchaseList(purchaseService.getAll());
    }

    @GetMapping(path = "{id}", produces = {"text/xml", "application/xml"})
    public Purchase getById(@PathVariable Integer id) {
        return purchaseService.getById(id);
    }

    @PostMapping(consumes = {"text/xml", "application/xml"},
            produces = {"text/xml", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public Purchase add(@RequestBody Purchase purchase) {
        return purchaseService.create(purchase);
    }

    @PutMapping(consumes = {"text/xml", "application/xml"},
            produces = {"text/xml", "application/xml"})
    public Purchase update(@RequestBody Purchase purchase) {
        return purchaseService.update(purchase);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        purchaseService.deleteById(id);
    }

}
