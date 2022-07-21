package com.example.purchases.service;

import com.example.purchases.model.Purchase;
import com.example.purchases.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final EntityManager entityManager;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, EntityManager entityManager) {
        this.purchaseRepository = purchaseRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<Purchase> getAll() {
        entityManager.clear();
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase getById(int id) {
        return purchaseRepository.findById(id).get();
    }

    @Override
    public Purchase create(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase update(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    @Override
    public void deleteById(int id) {
        purchaseRepository.deleteById(id);
    }
}
