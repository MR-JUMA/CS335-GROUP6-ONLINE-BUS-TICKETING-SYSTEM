package com.example.abc.models;

import javax.persistence.*;

@Entity
public class Fare extends Common{

    @ManyToOne
    private  Route Route;

    private String BusFare;

    public com.example.abc.models.Route getRoute() {
        return Route;
    }

    public void setRoute(com.example.abc.models.Route route) {
        Route = route;
    }

    public String getBusFare() {
        return BusFare;
    }

    public void setBusFare(String busFare) {
        BusFare = busFare;
    }
}
