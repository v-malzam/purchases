package com.example.purchases.service.impl;

import com.example.purchases.model.Buyer;
import com.example.purchases.repository.BuyerRepository;
import com.example.purchases.service.BuyerService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepository buyerRepository;
    private final EntityManager entityManager;

    public BuyerServiceImpl(BuyerRepository buyerRepository, EntityManager entityManager) {
        this.buyerRepository = buyerRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<Buyer> getAll() {
        entityManager.clear();
        return buyerRepository.findAll();
    }

    @Override
    public Buyer getById(int id) {
        return buyerRepository.findById(id).get();
    }

    @Override
    public Buyer create(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @Override
    public Buyer update(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @Override
    public void deleteById(int id) {
        buyerRepository.deleteById(id);
    }
}
