package com.flightreservation_app;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightreservation_app.entity.Reservation;
import com.flightreservation_app.repository.ReservationRepository;
import com.flightreservation_app.util.EmailUtil;
import com.flightreservation_app.util.PdfGenerator;

@SpringBootTest
class FlightreservationAppApplicationTests {
	
	@Autowired
	private EmailUtil email;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private ReservationRepository reservationRepo;
//
//	@Test
//	void contextLoads() throws Exception{
//		Reservation reservation = reservationRepo.findById(1).get();
//		String filePath = "D:\\FlightTickets\\flightTicket"+reservation.getId()+".pdf";
//		pdfGenerator.generatePdf(reservation, filePath);
//		
//	}
	
	@Test
	void sendEmail() throws Exception{
		Reservation reservation = reservationRepo.findById(1).get();
		email.sendEmail(reservation.getPassenger().getEmail(),new File("D:\\FlightTickets\\flightTicket1.pdf"));
	}

}
