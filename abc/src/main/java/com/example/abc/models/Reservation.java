package com.example.abc.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Reservation extends Common{

    private Date BookingDate;
    private Date DepartureDate;
    private String Type;
    private String TotalFare;

    @ManyToOne
    private Customer CustomerID;
    @ManyToOne
    private BusType Bus;
    @ManyToOne
    private User User;

    public Date getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        BookingDate = bookingDate;
    }

    public Date getDepartureDate() {
        return DepartureDate;
    }

    public void setDepartureDate(Date departureDate) {
        DepartureDate = departureDate;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getTotalFare() {
        return TotalFare;
    }

    public void setTotalFare(String totalFare) {
        TotalFare = totalFare;
    }

    public Customer getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Customer customerID) {
        CustomerID = customerID;
    }

    public BusType getBus() {
        return Bus;
    }

    public void setBus(BusType bus) {
        Bus = bus;
    }

    public com.example.abc.models.User getUser() {
        return User;
    }

    public void setUser(com.example.abc.models.User user) {
        User = user;
    }
}
