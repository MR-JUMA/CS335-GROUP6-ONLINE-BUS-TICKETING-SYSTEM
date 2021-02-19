package com.example.abc.models;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;


@Entity
public class BusSchedule extends Common{

    private String DepartureCity;
    private String ArrivalCity;
    private String Fare;
    @JsonFormat(pattern = "yyyy-MM-dd", shape= JsonFormat.Shape.STRING)
    private Date TravelDate;

    @OneToOne
    private Bus bus;


    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
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

    public String getFare() {
        return Fare;
    }

    public void setFare(String fare) {
        Fare = fare;
    }

    public Date getTravelDate() {
        return TravelDate;
    }

    public void setTravelDate(Date travelDate) {
        TravelDate = travelDate;
    }

    @Override
    public String toString() {
        return "BusSchedule{" +
                "DepartureCity='" + DepartureCity + '\'' +
                ", ArrivalCity='" + ArrivalCity + '\'' +
                ", Fare='" + Fare + '\'' +
                ", TravelDate=" + TravelDate +
                '}';
    }
}
