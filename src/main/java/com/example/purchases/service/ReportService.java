package com.example.purchases.service;

import com.example.purchases.model.Buyer;
import com.example.purchases.model.Product;
import com.example.purchases.model.Purchase;

import java.util.LinkedHashMap;
import java.util.List;

public interface ReportService {

    List<Purchase> purchasesLastWeek();

    LinkedHashMap<Integer, Product> bestsellerLastMonth();

    LinkedHashMap<Integer, Buyer> bestbuyerLastYear();

    LinkedHashMap<Integer, Product> bestsellerFor18YearOld();
}
