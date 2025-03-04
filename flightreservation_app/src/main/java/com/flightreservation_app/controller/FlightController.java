package com.flightreservation_app.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation_app.entity.Flight;
import com.flightreservation_app.repository.FlightRepository;

@Controller
public class FlightController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);
	
	@Autowired
	private FlightRepository flightRepository;

	@RequestMapping(value = "/findFlights",method=RequestMethod.POST)
	public String findFlights(@RequestParam("from") String from,@RequestParam("to") String to,@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,ModelMap modelMap) {
		LOGGER.info("Inside findFlights() From : "+from+" To : "+to+"Departure Date : "+departureDate);
		List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
		LOGGER.info("Flights : "+flights);
		modelMap.addAttribute("flights", flights);
		return "displayFlights";
	}
	
	@RequestMapping(value="/admin/addFlight")
	public String addFlight() {
		return "addFlight";
	}
}
