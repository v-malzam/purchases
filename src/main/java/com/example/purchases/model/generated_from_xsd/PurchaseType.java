package com.example.purchases.model.generated_from_xsd;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import java.math.BigDecimal;
import java.math.BigInteger;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PurchaseType", propOrder = {
    "buyer",
    "product",
    "count",
    "amount",
    "date"
})
public class PurchaseType {

    @XmlElement(required = true)
    protected BuyerType buyer;

    @XmlElement(required = true)
    protected ProductType product;

    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger count;

    @XmlElement(required = true)
    protected BigDecimal amount;

    @XmlElement(required = true)
    protected String date;

    public BuyerType getBuyer() {
        return buyer;
    }

    public void setBuyer(BuyerType value) {
        this.buyer = value;
    }

    public ProductType getProduct() {
        return product;
    }

    public void setProduct(ProductType value) {
        this.product = value;
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger value) {
        this.count = value;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String value) {
        this.date = value;
    }
}
