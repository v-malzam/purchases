package com.example.purchases.controller_rest;

import com.example.purchases.model.Purchase;
import com.example.purchases.model.PurchaseList;
import com.example.purchases.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public PurchaseList getAll() {
        return new PurchaseList(purchaseService.getAll());
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public Purchase getById(@PathVariable Integer id) {
        return purchaseService.getById(id);
    }

    @PostMapping(consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Purchase add(@RequestBody Purchase purchase) {
        return purchaseService.create(purchase);
    }

    @PutMapping(consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE)
    public Purchase update(@RequestBody Purchase purchase) {
        return purchaseService.update(purchase);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        purchaseService.deleteById(id);
    }

}
