package com.example.purchases.model.generated_from_xsd;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BuyerType")
public class BuyerType {

    @XmlAttribute(name = "name", required = true)
    protected String name;

    @XmlAttribute(name = "lastname", required = true)
    protected String lastname;

    @XmlAttribute(name = "age", required = true)
    protected int age;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String value) {
        this.lastname = value;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int value) {
        this.age = value;
    }

}
