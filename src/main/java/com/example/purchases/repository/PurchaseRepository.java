package com.example.purchases.repository;

import com.example.purchases.model.Buyer;
import com.example.purchases.model.Product;
import com.example.purchases.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    @Query("from Purchase p where p.date > ?1")
    List<Purchase> purchasesLastWeek(LocalDate lastWeek);

    @Query(nativeQuery = true, value =
            "SELECT sum(count) s, product.name n" +
                    " FROM purchase" +
                    " JOIN product ON (purchase.product_id = product.id)" +
                    " WHERE date > ?1" +
                    " GROUP BY n" +
                    " ORDER BY s DESC")
    LinkedHashMap<Integer, Product> bestSellerLastMonth(LocalDate lastMonth);

    @Query(nativeQuery = true, value =
            "SELECT sum(count) s, buyer.id i, buyer.name, buyer.lastname" +
                    " FROM purchase" +
                    " JOIN buyer ON (purchase.buyer_id = buyer.id)" +
                    " WHERE date > ?1" +
                    " GROUP BY i" +
                    " ORDER BY s DESC")
    LinkedHashMap<Integer, Buyer> bestBuyerLastYear(LocalDate lastYear);

    @Query(nativeQuery = true, value =
            "SELECT sum(count) s, product.name n" +
                    " FROM purchase" +
                    " JOIN buyer ON (purchase.buyer_id = buyer.id)" +
                    " JOIN product ON (purchase.product_id = product.id)" +
                    " WHERE buyer.age = 18" +
                    " GROUP BY n" +
                    " ORDER BY s DESC")
    LinkedHashMap<Integer, Product> bestSellerFor18YearOld();
}
