package com.flight_reservation_app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight_reservation_app.enities.Flight;
import com.flight_reservation_app.repositories.FlightRepository;

@Controller
public class FlightController {
	
	@Autowired
	private FlightRepository flightRepo;
	
	
	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("to") String to, @RequestParam("from") String from, @RequestParam("departureDate") @DateTimeFormat(pattern ="MM-dd-yyyy") Date departureDate, Model model) {
		List<Flight> findFlights = flightRepo.findFlights(to, from, departureDate);
		System.out.println(findFlights);
		return"";
	}

}
