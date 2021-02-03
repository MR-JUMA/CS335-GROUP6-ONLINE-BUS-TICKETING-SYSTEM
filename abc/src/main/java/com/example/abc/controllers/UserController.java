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

import com.example.abc.dao.FormValidationGroup;
import com.example.abc.dao.Reserve;
import com.example.abc.dao.User;
import com.exampe.abc.service.ReserveService;
import com.example.abc.service.UserService;



@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	ReserveService reserveService;

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/loggedout")
	public String showLogout() {
		return "loggedout";
	}
	
	
	@RequestMapping("/createaccount")
	public String createAccount(Model model, Principal principal) {
		
		model.addAttribute("user", new User());
		
		return "createaccount";
	}

	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	public String createUser(@Validated(FormValidationGroup.class) User user, BindingResult result) {
		
		if(result.hasErrors()) {
			return "createaccount";
		}
		
		user.setAuthority("ROLE_USER");
		user.setEnabled(true);

		userService.create(user);
		
		return "home";

	}

	@RequestMapping(value = "/reservebook", method = RequestMethod.POST)
	public String createReserveBook(@Validated(FormValidationGroup.class) Reserve reserve, BindingResult result, Principal principal) {
		
		if (result.hasErrors()) {
			return "reservebus";
		}
		
		String username = principal.getName();
		reserve.getUser().setUsername(username);
		
		reserveService.reserve(reserve);
	
		
		return "home";

	}
	
	@RequestMapping(value = "/getreservations", method = RequestMethod.GET)
	public String getReserveBook(@Validated(FormValidationGroup.class) Reserve reserve, Model model, Principal principal) {
		
		
		String username = principal.getName();
		reserve.getUser().setUsername(username);
		
		List<Reserve> reserves = reserveService.getReserves(username);
		model.addAttribute("reserves", reserves);
		System.out.println(reserves);
	
		
		return "home";

	}
	

}



