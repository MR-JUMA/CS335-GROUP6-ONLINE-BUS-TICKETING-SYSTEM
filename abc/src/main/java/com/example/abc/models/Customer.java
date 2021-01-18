package com.example.abc.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    private int CustID;
    private String FirstName;
    private String LastName;

}
