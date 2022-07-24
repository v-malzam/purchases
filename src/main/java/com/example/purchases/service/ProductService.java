package com.example.purchases.service;

import com.example.purchases.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product getById(int id);

    Product create(Product product);

    Product update(Product product);

    void deleteById(int id);
}
