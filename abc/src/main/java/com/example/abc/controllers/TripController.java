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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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

//    @RequestMapping(value ="/addTrip",method=RequestMethod.POST)
//    public String addTrip(BusSchedule busSchedule){
//        scheduleRepository.save(busSchedule);
//        return "admin";
//    }


    @RequestMapping(value ="/addTrip",method=RequestMethod.POST)
    public String addTrip(BusSchedule busSchedule, @RequestParam("Fare") String Fare, HttpServletRequest request){

        List<String> notes = (List<String>) request.getSession().getAttribute("NOTES_SESSION");
        //check if notes is present in session or not
        if (notes == null) {
            notes = new ArrayList<>();
            // if notes object is not present in session, set notes in the request session
            request.getSession().setAttribute("NOTES_SESSION", notes);
        }
       notes.add(Fare);
        request.getSession().setAttribute("NOTES_SESSION", notes);
        System.out.println(notes);
        System.out.println("lukelo");
        scheduleRepository.save(busSchedule);
        return "admin";
    }


    public int sum(int a,int b){
        return a+b;
    }
//
}

//        List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
//        if (messages == null) {
//            messages = new ArrayList<>();
//            request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
//        }
//        messages.add("lukelo");
//        request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
//        System.out.println(messages);