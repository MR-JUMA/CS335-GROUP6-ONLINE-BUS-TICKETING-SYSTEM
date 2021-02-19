package com.example.abc.controllers;

import com.example.abc.models.*;
import com.example.abc.repositories.*;
import com.example.abc.services.BusService;
import com.example.abc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    BusService busService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/ab",method = RequestMethod.GET)
    public String homePage(ModelMap modelMap){
        modelMap.addAttribute("count",userRepository.count());
        modelMap.addAttribute("trip",scheduleRepository.count());

        List<BusSchedule> schedules=scheduleRepository.findAll();
        modelMap.addAttribute("schedules",schedules);
        return "admin";
    }

    @RequestMapping(value = "/addingBus")
    public String addingBus(){
        return "addBuses";
    }

    @RequestMapping(value = "/addBus")
    public String saveBus(Bus bus){
        busRepository.save(bus);
        return "redirect:/ab";
    }

    @RequestMapping(value = "/addingCity")
    public String addingCity(){
        return "addCity";
    }

    @RequestMapping(value = "/addCity",method= RequestMethod.POST)
    public String addCity(City city) {
        cityRepository.save(city);
        return "redirect:/ab";
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
        return "redirect:/ab";
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
        return "redirect:/ab";
    }

    @RequestMapping(value = "/viewBus",method = RequestMethod.GET)
    public String viewBuses(ModelMap modelMap){
        List<Bus> buses=busRepository.findAll();
        modelMap.addAttribute("buses",buses);
        return "viewBus";
    }

    @RequestMapping("/editBus/{id}")
    public String editBus(@PathVariable("id")int id, ModelMap modelMap){
        Bus bus= busService.getBusById(id);
        modelMap.addAttribute("bus",bus);
        return "editBus";
    }

    @RequestMapping("/updateBus/{id}")
    public String updateBus(@PathVariable("id")int id,Bus bus,ModelMap modelMap){
        busRepository.save(bus);
        List<Bus> buses=busRepository.findAll();
        modelMap.addAttribute("buses",buses);
        return "viewBus";
    }

    @RequestMapping("/deleteBus/{id}")
    public String deleteBus(@PathVariable("id")int id){
        busRepository.deleteById((long) id);
        return "redirect:/viewBus";
    }

    @RequestMapping("/viewUser")
    public String viewUsers(ModelMap modelMap){
        List<User> users=userRepository.findAll();
        modelMap.addAttribute("users",users);
        return "viewUser";
    }

    @RequestMapping("/editUser/{id}")
    public String editUser(@PathVariable("id")int id, ModelMap modelMap){
        User user=userService.getUserById(id);
        modelMap.addAttribute("user",user);
        return "editUser";
    }

    @RequestMapping("updateUser/{id}")
    public String updateUser(@PathVariable("id")int id,User user,ModelMap modelMap){
        userRepository.save(user);
        List<User> users=userRepository.findAll();
        modelMap.addAttribute("users",users);

        return "viewUser";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id")int id){
        userRepository.deleteById((long) id);
        return "redirect:/viewUser";
    }

}
