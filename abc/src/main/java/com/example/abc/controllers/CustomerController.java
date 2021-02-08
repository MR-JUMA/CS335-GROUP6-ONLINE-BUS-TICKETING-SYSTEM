package com.example.abc.controllers;

import com.example.abc.models.Customer;
import com.example.abc.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;


    @RequestMapping("/homepage")
    public String home(){
        return "homepage";
    }

    @RequestMapping("/addCustomer")
    public String addCustomer(){
        return "RegisterCustomer";
    }

//    @RequestMapping("/RegisterCustomer")
//    public String saveCustomer(Customer customer){
//         customerRepository.save(customer);
//         return "viewCustomer";
//    }

    @RequestMapping("/viewCustomer")
    public String viewCustomer(ModelMap modelMap){
       List<Customer> customer= customerRepository.findAll();
       modelMap.addAttribute("customer",customer);
        return "viewCustomer";
    }

}


