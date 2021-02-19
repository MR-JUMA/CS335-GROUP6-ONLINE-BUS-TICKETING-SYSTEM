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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
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
    @RequestMapping("/book")
    public String book(){

        return "booking";
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

    @RequestMapping("/session")
    public String receive(@RequestParam("luke")String price, @RequestParam("settings[]") ArrayList seat
            , @RequestParam("sett")String amount, HttpServletRequest request){
        List<String> notes = (List<String>) request.getSession().getAttribute("BUS");
        ArrayList<Object> seats = (ArrayList<Object>) request.getSession().getAttribute("seat");
        //check if notes is present in session or not
        if (notes == null) {
            notes = new ArrayList<>();
            // if notes object is not present in session, set notes in the request session
            request.getSession().setAttribute("BUS", notes);
        }
        if (seats == null) {
            seats = new ArrayList<>();
            // if notes object is not present in session, set notes in the request session
            request.getSession().setAttribute("seat", seats);
        }
        notes.add(price);
        notes.add(amount);
        seats.add(seat);

        request.getSession().setAttribute("seat", seats);

        request.getSession().setAttribute("BUS", notes);
        System.out.println(notes);
        System.out.println(seats);

        return "redirect:/provide";
    }


    @RequestMapping("/provide")
    public String displaySafaris(HttpSession session,ModelMap modelMap){
        List<String> notes = (List<String>) session.getAttribute("BUS");
        List<String> seats = (List<String>) session.getAttribute("seat");

        modelMap.addAttribute("notes",notes);
        modelMap.addAttribute("seats",seats);

        return "booking";
    }
//    @RequestMapping("/provide")
//    public String inputInfo(@RequestParam("firstName")String firstName,@RequestParam("lastName")String lastName,
//                            @RequestParam("phone")String phone,@RequestParam("email")String email,HttpServletRequest request){
//        List<String> details = (List<String>) request.getSession().getAttribute("DETAILS");
//        if (details == null) {
//            details = new ArrayList<>();
//            // if notes object is not present in session, set notes in the request session
//            request.getSession().setAttribute("DETAILS", details);
//        }
//        details.add(firstName);
//        details.add(lastName);
//        details.add(phone);
//        details.add(email);
//
//        request.getSession().setAttribute("DETAILS", details);
//
//        return "booking";
//    }





    @PostMapping("/invalidate/session")
    public String destroySession(HttpServletRequest request) {
        //invalidate the session , this will clear the data from configured database (Mysql/redis/hazelcast)
        request.getSession().invalidate();
        return "redirect:/homepage";
    }




//    @RequestMapping("/search")
//    public String displaySafaris(String DepartureCity,String ArrivalCity,ModelMap modelMap){
//        BusSchedule schedule=scheduleRepository.display(DepartureCity,ArrivalCity);
//        modelMap.addAttribute("schedule",schedule);
//        return "displayTrips";
//    }




}


