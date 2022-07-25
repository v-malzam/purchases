package com.example.purchases.model.generated_from_xsd;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"purchase"})
@XmlRootElement(name = "Purchases")
public class Purchases {

    @XmlElement(required = true)
    protected List<PurchaseType> purchase;

    public List<PurchaseType> getPurchase() {
        if (purchase == null) {
            purchase = new ArrayList<PurchaseType>();
        }
        return this.purchase;
    }
}
