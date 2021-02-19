package com.example.abc.services;


import com.example.abc.models.Customer;
import com.example.abc.repositories.CustomerRepository;
import com.example.abc.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ScheduleRepository scheduleRepository;


    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer displayTrips(String DepartureCity, String ArrivalCity, String TravelDate) {
        return null;
    }


}
