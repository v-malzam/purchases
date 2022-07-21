package com.example.purchases.repository;

import com.example.purchases.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    @Query("from Purchase p where p.date > ?1")
    List<Purchase> recentPurchases(LocalDate startDate);
}
