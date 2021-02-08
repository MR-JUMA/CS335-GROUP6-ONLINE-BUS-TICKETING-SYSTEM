package com.example.abc.controllers;

import com.example.abc.models.*;
import com.example.abc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    BusRepository busRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping(value = "/ab",method = RequestMethod.GET)
    public String homePage(ModelMap modelMap){
        List<BusSchedule> schedules=scheduleRepository.findAll();
        modelMap.addAttribute("schedules",schedules);
        return "admin";
    }

    @RequestMapping("/addingBus")
    public String addBus(){
        return "addBuses";
    }

    @RequestMapping(value = "/addBus")
    public String saveBus(Bus bus){
        busRepository.save(bus);
        return "admin";
    }

    @RequestMapping("/addingCity")
    public String CityHome(){
        return "addCity";
    }

    @RequestMapping(value = "/addCity",method= RequestMethod.POST)
    public String addCity(City city) {
        cityRepository.save(city);
        return "admin";
    }

    @RequestMapping(value = "/addingBranch",method = RequestMethod.GET)
    public String homeBranch(ModelMap modelMap){
        List<City> cities=cityRepository.findAll();
        modelMap.addAttribute("cities",cities);
        return "addBranch";
    }

    @RequestMapping(value = "/addBranch",method= RequestMethod.POST)
    public String addCity(Branch branch){
        branchRepository.save(branch);
        return "admin";
    }

    @RequestMapping(value = "/addingUser",method = RequestMethod.GET)
    public String userAdding(ModelMap modelMap){
        List<Branch> branches=branchRepository.findAll();
        List<Role> roles=roleRepository.findAll();
        modelMap.addAttribute("branches",branches);
        modelMap.addAttribute("roles",roles);
        return "addUser";
    }

    @RequestMapping(value = "/addUser",method= RequestMethod.POST)
    public String addUser(User user){
        userRepository.save(user);
        return "admin";
    }



}
