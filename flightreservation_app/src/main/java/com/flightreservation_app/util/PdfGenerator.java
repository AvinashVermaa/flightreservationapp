package com.flightreservation_app.util;

import org.springframework.stereotype.Component;

import com.flightreservation_app.entity.Reservation;

@Component
public interface PdfGenerator {

	public void generatePdf(Reservation reservation,String filePath) throws Exception;
}
