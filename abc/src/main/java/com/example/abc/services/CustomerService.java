package com.example.abc.services;

import com.example.abc.models.Customer;

public interface CustomerService {
    Customer saveCustomer(Customer customer);

    Customer displayTrips(String DepartureCity,String ArrivalCity,String TravelDate);
}
