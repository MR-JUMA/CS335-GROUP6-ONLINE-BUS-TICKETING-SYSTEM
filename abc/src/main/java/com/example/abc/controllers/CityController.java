package com.example.abc.controllers;

import com.example.abc.models.City;
import com.example.abc.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CityController {
    @Autowired
    CityRepository cityRepository;






}
