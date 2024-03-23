package com.flightreservation_app.service;

import org.springframework.stereotype.Component;

import com.flightreservation_app.dto.ReservationData;
import com.flightreservation_app.entity.Reservation;

@Component
public interface ReservationService {

	public Reservation completeReservation(ReservationData reservationData,int flightId) throws Exception;
}
