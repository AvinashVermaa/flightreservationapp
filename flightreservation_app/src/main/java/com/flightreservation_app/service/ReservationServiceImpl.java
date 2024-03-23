package com.flightreservation_app.service;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.flightreservation_app.dto.ReservationData;
import com.flightreservation_app.entity.Flight;
import com.flightreservation_app.entity.Passenger;
import com.flightreservation_app.entity.Reservation;
import com.flightreservation_app.repository.FlightRepository;
import com.flightreservation_app.repository.PassengerRepository;
import com.flightreservation_app.repository.ReservationRepository;
import com.flightreservation_app.util.EmailUtil;
import com.flightreservation_app.util.PdfGenerator;

@Component
public class ReservationServiceImpl implements ReservationService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailUtil emailUtil;

	@Override
	@Transactional
	public Reservation completeReservation(ReservationData reservationData, int flightId) throws Exception{
		
		LOGGER.info("Inside completeReservation() : "+reservationData+" Flight Id : "+flightId);
		//payment data in future use:
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(reservationData.getPassengerFirstName());
		passenger.setLastName(reservationData.getPassengerLastName());
		passenger.setMiddleName(reservationData.getPassengerMiddleName());
		passenger.setEmail(reservationData.getPassengerEmail());
		passenger.setPhone(reservationData.getPassengerPhone());
		
		//save the passenger data into db:
		Passenger savedPassenger = passengerRepo.save(passenger);
		
		LOGGER.info("Saved Passenger : "+savedPassenger);
		
		//get the flightId from db:
		Flight flight = flightRepo.findById(flightId).get();
		
		LOGGER.info("Fetched the Flight : "+flight);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		
		//save the reservation into db:
		Reservation savedReservation = reservationRepo.save(reservation);
		
		LOGGER.info("Saved the reservation : "+savedReservation);
		
		String filePath = "D:\\FlightTickets"+savedReservation.getId()+".pdf";
		
		LOGGER.info("Getting the filePath : "+filePath);
		
		pdfGenerator.generatePdf(savedReservation, filePath);
		
		emailUtil.sendEmail(passenger.getEmail(), new File(filePath));
		
		return savedReservation;
	}

}
