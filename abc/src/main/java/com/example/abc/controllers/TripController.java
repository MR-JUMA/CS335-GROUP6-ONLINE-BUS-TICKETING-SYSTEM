package com.example.abc.controllers;

import com.example.abc.models.Bus;
import com.example.abc.models.BusSchedule;
import com.example.abc.models.City;
import com.example.abc.repositories.BusRepository;
import com.example.abc.repositories.CityRepository;
import com.example.abc.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TripController {

    @Autowired
    BusRepository busRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    CityRepository cityRepository;



    @RequestMapping(value = "/tripAdding",method = RequestMethod.GET)
    public String tripAdd(ModelMap modelMap){
        List<Bus> buses=busRepository.findAll();
        List<City> cities=cityRepository.findAll();
        modelMap.addAttribute("buses",buses);
        modelMap.addAttribute("cities",cities);
        return "addTrip";
    }



    @RequestMapping(value ="/addTrip",method=RequestMethod.POST)
    public String addTrip(BusSchedule busSchedule){
        scheduleRepository.save(busSchedule);
        return "admin";
    }


    public int sum(int a,int b){
        return a+b;
    }
//
}
