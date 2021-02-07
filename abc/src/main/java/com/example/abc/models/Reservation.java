package com.example.abc.models;

import javax.persistence.*;
import java.sql.Date;



@Entity
public class Reservation extends Common{

    private Date BookingDate;

    @ManyToOne
    private Customer CustomerID;

    @ManyToOne
    private BusSchedule busSchedule;

    @ManyToOne
    private User User;


    public Date getBookingDate() {
        return BookingDate;
    }

    public BusSchedule getBusSchedule() {
        return busSchedule;
    }

    public void setBusSchedule(BusSchedule busSchedule) {
        this.busSchedule = busSchedule;
    }

    public void setBookingDate(Date bookingDate) {
        BookingDate = bookingDate;
    }

    public Customer getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Customer customerID) {
        CustomerID = customerID;
    }


    public com.example.abc.models.User getUser() {
        return User;
    }

    public void setUser(com.example.abc.models.User user) {
        User = user;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "BookingDate=" + BookingDate +
                ", CustomerID=" + CustomerID +
                ", busSchedule=" + busSchedule +
                ", User=" + User +
                '}';
    }
}
