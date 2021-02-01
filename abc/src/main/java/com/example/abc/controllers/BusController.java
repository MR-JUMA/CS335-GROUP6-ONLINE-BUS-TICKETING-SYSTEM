package com.example.abc.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.abc.dao.Bus;
import com.example.abc.dao.FormValidationGroup;
import com.example.abc.service.BusService;

@Controller
public class BusController {

	@Autowired
	BusService busService;
	

	@RequestMapping("/createtrip")
	public String reserveBus(Model model, Principal principal) {

		model.addAttribute("bus", new Bus());

		return "createtrip";
	}

	@RequestMapping(value = "/createreserve", method = RequestMethod.POST)
	public String createReserve(@Validated(FormValidationGroup.class) Bus bus, BindingResult result,
			Principal principal) {

		if (result.hasErrors()) {
			return "reservebus";
		}

		busService.create(bus);

		return "home";

	}

	@RequestMapping("/results")
	public String leave(Model model, Principal principal) {

		model.addAttribute("bus", new Bus());

		return "results";
	}
	

	@RequestMapping(value = "/resultsfrom", method = RequestMethod.GET)
	public String leaveFrom(@Validated(FormValidationGroup.class) Bus bus, BindingResult result, Model model,
			Principal principal) {

		List<Bus> results = busService.getCity(bus.getLeaveFrom(), bus.getGoingTo(), bus.getDateLeave(),
				bus.getDateReturn());
		model.addAttribute("results", results);
		System.out.println(results);

		return "results";

	}

}
