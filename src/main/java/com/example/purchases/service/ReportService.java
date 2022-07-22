package com.example.purchases.service;

import com.example.purchases.model.Buyer;
import com.example.purchases.model.Product;
import com.example.purchases.model.Purchase;

import java.util.List;

public interface ReportService {

    List<Purchase> purchasesLastWeek();

    List<Product> bestsellerLastMonth();

    List<Buyer> bestbuyerLastYear();

    List<Product> bestsellerFor18YearOld();
}

/*Дискуссионный вопрос - что делать с интерфейсом?
 - По правилу I в SOLID, этот интерфейс нужно разбить на 4 отдельных. Можно функциональных.
 - Но может лучше контроллерам напрямую отчеты тянуть из репозитория,
  а сервисные интерфейсы с классами для отчетов удалить?
 - Но могут ли быть отчеты, для которых недостаточно SQL, а требуется компоновать DTO из разных объектов,
 реализовывать сложную логику дообработки? Тогда и отдельные интерфейсы, и имплементации нужны.
Такая вот ситуация буриданова ослика.*/