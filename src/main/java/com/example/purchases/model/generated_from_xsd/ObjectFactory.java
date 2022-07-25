package com.example.purchases.model.generated_from_xsd;

import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public Purchases createPurchases() {
        return new Purchases();
    }

    public PurchaseType createPurchaseType() {
        return new PurchaseType();
    }

    public BuyerType createBuyerType() {
        return new BuyerType();
    }

    public ProductType createProductType() {
        return new ProductType();
    }

}
