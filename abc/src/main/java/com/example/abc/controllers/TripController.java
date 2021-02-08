package com.example.abc.controllers;

import com.example.abc.models.Bus;
import com.example.abc.models.BusSchedule;
import com.example.abc.models.City;
import com.example.abc.repositories.BusRepository;
import com.example.abc.repositories.CityRepository;
import com.example.abc.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Date;
import java.util.List;

@Controller
public class TripController {

    @Autowired
    BusRepository busRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    CityRepository cityRepository;

//    @RequestMapping("/searchTrip")
//    public String searchTrip(String departureCity, String arrivalCity, Date departureDate, ModelMap modelMap){
//       List<BusSchedule> busSchedules=scheduleRepository.findTrip(departureCity,arrivalCity,departureDate);
//       modelMap.addAttribute("buses",busSchedules);
//        return "trips";
//    }
    @RequestMapping("/busAdding")
    public String busAdd(){
        return "addBus";
    }
    @RequestMapping("/addBus")
    public String addBus(Bus bus){
       busRepository.save(bus);
        return null;
    }


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
        return null;
    }

//    @Param("CLASS") BusType CLASS, @Param("DepartureCity")String DepartureCity,
//    @Param("ArrivalCity")String ArrivalCity, @Param("BusFare") Fare BusFare,
//    @Param("TravelDate")Date TravelDate,
}
