package com.example.abc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private int AddressID;
    private String Email;
    private String MobileNumber;

    @ManyToOne
    private Customer customer;


}
