package com.example.abc.controllers;

import com.example.abc.models.Branch;
import com.example.abc.models.Bus;
import com.example.abc.models.City;
import com.example.abc.repositories.BranchRepository;
import com.example.abc.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BranchController {
    @Autowired
    BranchRepository branchRepository;

    @Autowired
    CityRepository cityRepository;




}
