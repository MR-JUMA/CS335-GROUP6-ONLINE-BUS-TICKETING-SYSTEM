package com.example.abc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Route extends Common{

    private String BustStop;
    private String  RouteCode;

    public String getBustStop() {
        return BustStop;
    }

    public void setBustStop(String bustStop) {
        BustStop = bustStop;
    }

    public String getRouteCode() {
        return RouteCode;
    }

    public void setRouteCode(String routeCode) {
        RouteCode = routeCode;
    }
}
