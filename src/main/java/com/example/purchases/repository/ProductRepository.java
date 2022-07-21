package com.example.purchases.repository;

import com.example.purchases.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.LinkedHashMap;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(nativeQuery = true, value = "SELECT sum(count) s, product.name n FROM purchase JOIN product ON (purchase.product_id = product.id) WHERE date > ?1 GROUP BY n ORDER BY s DESC")
    LinkedHashMap<Integer, Product> bestSellerLastMonth(LocalDate lastMonth);

}
