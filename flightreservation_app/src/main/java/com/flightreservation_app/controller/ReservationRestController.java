package com.flightreservation_app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightreservation_app.dto.UpdateReservationRequest;
import com.flightreservation_app.entity.Reservation;
import com.flightreservation_app.repository.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {
	
	private static final Logger LOGGER =LoggerFactory.getLogger(ReservationRestController.class);

	@Autowired
	private ReservationRepository reservationRepo;
	
	@RequestMapping("/reservation/{id}")
	public ResponseEntity<Reservation> findReservation(@PathVariable("id") int id){
		LOGGER.info("Inside findReservation() id : "+id);
		Reservation reservation = reservationRepo.findById(id).get();
		LOGGER.info("Getting the reservation : "+reservation);
		return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
		
	}
	
	@RequestMapping("/updatereservation")
	public ResponseEntity<Reservation> updateReservation(@RequestBody UpdateReservationRequest request){
		LOGGER.info("Inside updateReservation() request : "+request);
		int id = request.getId();
		Reservation reservation = reservationRepo.findById(id).get();
		reservation.setCheckedIn(true);
		reservation.setNumberOfBags(request.getNumberOfBags());
		
		Reservation savedReservation = reservationRepo.save(reservation);
		
		LOGGER.info("Saving the reservation : "+savedReservation);
		return new ResponseEntity<Reservation>(savedReservation, HttpStatus.OK);
	}
	
}
