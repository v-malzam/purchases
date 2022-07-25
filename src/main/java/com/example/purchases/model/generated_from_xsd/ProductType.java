package com.example.purchases.model.generated_from_xsd;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductType")
public class ProductType {

    @XmlAttribute(name = "name", required = true)
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }
}
