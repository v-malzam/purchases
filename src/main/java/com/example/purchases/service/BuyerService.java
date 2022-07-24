package com.example.purchases.service;

import com.example.purchases.model.Buyer;

import java.util.List;

public interface BuyerService {

    List<Buyer> getAll();

    Buyer getById(int id);

    Buyer create(Buyer buyer);

    Buyer update(Buyer buyer);

    void deleteById(int id);
}
