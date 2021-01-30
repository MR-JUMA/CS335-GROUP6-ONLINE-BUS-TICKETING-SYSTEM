package com.example.abc.models;

import javax.persistence.*;

@Entity
public class Branch extends Common{
    private String CenterName;
    private String Street;

    @ManyToOne
    private City City;

    public String getCenterName() {
        return CenterName;
    }

    public void setCenterName(String centerName) {
        CenterName = centerName;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public com.example.abc.models.City getCity() {
        return City;
    }

    public void setCity(com.example.abc.models.City city) {
        City = city;
    }
}
