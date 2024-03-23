package com.flightreservation_app.util;

import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.flightreservation_app.entity.Reservation;
import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PdfGeneratorImpl implements PdfGenerator{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PdfGeneratorImpl.class);

	@Override
	public void generatePdf(Reservation reservation, String filePath) throws Exception{
		LOGGER.info("Inside generatePdf() : reservation : "+reservation+" FilePath : "+filePath);
		Document document = new Document();
		
		PdfWriter.getInstance(document, new FileOutputStream(filePath));
		
		document.open();
		
		document.add(generateTable(reservation));
		
		document.close();
		
		
		
	}
	
	private PdfPTable generateTable(Reservation reservation) {
		LOGGER.info("Inside generateTable() reservation : "+reservation);
		PdfPTable table = new PdfPTable(2);
		
		PdfPCell cell;
		
		cell = new PdfPCell(new Phrase("Avinash Flight Company"));
		cell.setColspan(2);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDepartureCity());
		
		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArrivalCity());
		
		table.addCell("Operating Airlines");
		table.addCell(reservation.getFlight().getOperatingAirlines());
		
		table.addCell("Departure Date");
		table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());
		
		cell = new PdfPCell(new Phrase("Passenger Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("First Name");
		table.addCell(reservation.getPassenger().getFirstName());
		
		table.addCell("Last Name");
		table.addCell(reservation.getPassenger().getLastName());
		
		table.addCell("Email");
		table.addCell(reservation.getPassenger().getEmail());
		
		table.addCell("Phone");
		table.addCell(reservation.getPassenger().getPhone());
		
		return table;
		
		
		
		
	}

}
