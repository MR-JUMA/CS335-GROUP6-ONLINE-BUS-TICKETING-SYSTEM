package com.example.abc.models;


import javax.persistence.*;
import java.sql.Date;

@Entity
public class BusSchedule extends Common{

    private String PlateNumber;
    private String Type;
    private String DepartureCity;
    private String ArrivalCity;
    private String Fare;
    private Date TravelDate;


    public String getPlateNumber() {
        return PlateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        PlateNumber = plateNumber;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
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
}
