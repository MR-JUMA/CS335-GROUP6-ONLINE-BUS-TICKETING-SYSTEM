package com.example.abc.models;

import javax.persistence.*;

@Entity
public class Branch extends Common{
    private String CenterName;

    @ManyToOne
    private City City;


    public String getCenterName() {
        return CenterName;
    }

    public void setCenterName(String centerName) {
        CenterName = centerName;
    }



    public com.example.abc.models.City getCity() {
        return City;
    }

    public void setCity(com.example.abc.models.City city) {
        City = city;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "CenterName='" + CenterName + '\'' +
                ", City=" + City +
                '}';
    }
}
