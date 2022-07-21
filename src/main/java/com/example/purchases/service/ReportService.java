package com.example.purchases.service;

import com.example.purchases.model.Buyer;
import com.example.purchases.model.Product;
import com.example.purchases.model.Purchase;

import java.util.List;

public interface ReportService {

    List<Purchase> purchasesLastWeek();

    Product bestsellerLastMonth();

    Buyer bestbuyerLastYear();

    Product bestsellerFor18YearOld();
}
