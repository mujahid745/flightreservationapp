package com.flight_reservation_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight_reservation_app.enities.User;
import com.flight_reservation_app.repositories.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/showReg")
	public String showRegistration() {
		return "login/registration";
	}
	
	@RequestMapping("/saveReg")
	public String saveRegistration(@ModelAttribute("user") User user) {
		userRepo.save(user);
		return "login/login";
	}
	
	@RequestMapping("/verifyLogin")
	public String verifyLoginDetails(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap model) {
		User user = userRepo.findByEmail(email);
		if(user != null) {
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return "flights";
			} else {
				model.addAttribute("error", "incorrect email/password");
				return "login/login";
			}
		} else {
			model.addAttribute("error", "incorrect email/password");
			return "login/login";
		}
	}

}
