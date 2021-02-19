package com.example.abc.controllers;

import com.example.abc.models.BusSchedule;
import com.example.abc.models.City;
import com.example.abc.models.Customer;
import com.example.abc.repositories.CityRepository;
import com.example.abc.repositories.CustomerRepository;
import com.example.abc.repositories.ScheduleRepository;
import com.example.abc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    @RequestMapping("/homepage")
    public String userHomepage(ModelMap modelMap){
       List<City> places= cityRepository.findAll();
       modelMap.addAttribute("places",places);
        return "homepage";
    }
    @RequestMapping("/seat")
    public String user(){

        return "seat";
    }


    @RequestMapping("/search")
    public String displaySafaris(String DepartureCity,String ArrivalCity,ModelMap modelMap){
        List<BusSchedule> scheduleList=scheduleRepository.displayTrips(DepartureCity,ArrivalCity);
        modelMap.addAttribute("scheduleList",scheduleList);
//        BusSchedule hello=scheduleRepository.display();
//        modelMap.addAttribute("hello",hello);
        List<City> place= cityRepository.findAll();
        modelMap.addAttribute("place",place);
        return "displayTrips";
    }




//    @RequestMapping("/search")
//    public String displaySafaris(String DepartureCity,String ArrivalCity,ModelMap modelMap){
//        BusSchedule schedule=scheduleRepository.display(DepartureCity,ArrivalCity);
//        modelMap.addAttribute("schedule",schedule);
//        return "displayTrips";
//    }




}


