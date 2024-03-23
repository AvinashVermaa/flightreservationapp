package com.flightreservation_app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation_app.dto.ReservationData;
import com.flightreservation_app.entity.Flight;
import com.flightreservation_app.entity.Reservation;
import com.flightreservation_app.repository.FlightRepository;
import com.flightreservation_app.service.ReservationService;

@Controller
public class ReservationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping(value = "/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") int flightId,ModelMap modelMap) {
		LOGGER.info("Inside showCompleteReservation() flightId : "+flightId);
		Flight flight = flightRepo.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		LOGGER.info("Getted the flight object : "+flight);
		return "completeReservation";
	}
	
	@RequestMapping(value="/completeReservation",method=RequestMethod.POST)
	public String completeReservation(ReservationData reservationData,@RequestParam("flightId") int flightId,ModelMap modelMap) throws Exception{
		LOGGER.info("Inside completeReservation() Reservation Data : "+reservationData+" Flight Id : "+flightId);
		Reservation reservation = reservationService.completeReservation(reservationData, flightId);
		modelMap.addAttribute("msg", "Congrats your reservation was completed successfully the id is : "+reservation.getId());
		LOGGER.info("Getted the Reservation : "+reservation);
		return "completeReservationPage";
		
	}
	
}
