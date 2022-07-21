package com.example.purchases.service;

import com.example.purchases.model.Purchase;

import java.util.List;

public interface PurchaseService {

    List<Purchase> getAll();

    Purchase getById(int id);

    Purchase create(Purchase purchase);

    Purchase update(Purchase purchase);

    void deleteById(int id);
}
