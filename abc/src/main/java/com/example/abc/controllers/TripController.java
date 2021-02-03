package com.example.abc.controllers;

import com.example.abc.models.BusSchedule;
import com.example.abc.repositories.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.List;

@Controller
public class TripController {

    @Autowired
    BusRepository busRepository;

    @RequestMapping("/searchTrip")
    public String searchTrip(String departureCity, String arrivalCity, Date departureDate, ModelMap modelMap){
       List<BusSchedule> busSchedules=busRepository.findTrip(departureCity,arrivalCity,departureDate);
       modelMap.addAttribute("buses",busSchedules);
        return "trips";
    }

    @RequestMapping("/tripAdding")
    public String tripAdd(){
        return "addTrip";
    }

    @RequestMapping("/addTrip")
    public String addTrip(BusSchedule busSchedule){
        busRepository.save(busSchedule);
        return null;
    }

//    @Param("CLASS") BusType CLASS, @Param("DepartureCity")String DepartureCity,
//    @Param("ArrivalCity")String ArrivalCity, @Param("BusFare") Fare BusFare,
//    @Param("TravelDate")Date TravelDate,
}
