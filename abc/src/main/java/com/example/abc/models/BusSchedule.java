package com.example.abc.models;


import javax.persistence.*;
import java.sql.Date;

@Entity
public class BusSchedule extends Common{

    private Date TravelDate;
    private String DepartureCity;
    private String ArrivalCity;

    @ManyToOne
    private BusType BusType;

    @ManyToOne
    private Fare busFare;

    public Date getTravelDate() {
        return TravelDate;
    }

    public void setTravelDate(Date travelDate) {
        TravelDate = travelDate;
    }

    public String getDepartureCity() {
        return DepartureCity;
    }

    public void setDepartureCity(String departureCity) {
        DepartureCity = departureCity;
    }

    public String getArrivalCity() {
        return ArrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        ArrivalCity = arrivalCity;
    }

    public com.example.abc.models.BusType getBusType() {
        return BusType;
    }

    public void setBusType(com.example.abc.models.BusType busType) {
        BusType = busType;
    }

    public Fare getBusFare() {
        return busFare;
    }

    public void setBusFare(Fare busFare) {
        this.busFare = busFare;
    }
}
