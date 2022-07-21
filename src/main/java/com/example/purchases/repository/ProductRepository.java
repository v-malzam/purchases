package com.example.purchases.repository;

import com.example.purchases.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(nativeQuery = true, value =
            "SELECT product.id, product.name" +
                    " FROM purchase" +
                    " JOIN product ON (purchase.product_id = product.id)" +
                    " WHERE date > ?1" +
                    " GROUP BY product.id, product.name" +
                    " ORDER BY sum(count) DESC" +
                    " LIMIT 1")
    Product bestSellerLastMonth(LocalDate lastMonth);

    @Query(nativeQuery = true, value =
            "SELECT product.id, product.name" +
                    " FROM purchase" +
                    " JOIN buyer ON (purchase.buyer_id = buyer.id)" +
                    " JOIN product ON (purchase.product_id = product.id)" +
                    " WHERE buyer.age = 18" +
                    " GROUP BY product.id, product.name" +
                    " ORDER BY sum(count) DESC" +
                    " LIMIT 1")
    Product bestSellerFor18YearOld();
}
