package com.example.purchases.repository;

import com.example.purchases.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {

    @Query(nativeQuery = true, value =
            "SELECT buyer.id, buyer.name, buyer.lastname, buyer.age" +
                    " FROM purchase" +
                    " JOIN buyer ON (purchase.buyer_id = buyer.id)" +
                    " WHERE date > ?1" +
                    " GROUP BY buyer.id, buyer.name, buyer.lastname, buyer.age" +
                    " ORDER BY sum(count) DESC" +
                    " LIMIT 1")
    List<Buyer> bestBuyerLastYear(LocalDate startDate);
}
