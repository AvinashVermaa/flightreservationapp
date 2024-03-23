package com.flightreservation_app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightreservation_app.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

	@Query("FROM Flight WHERE departureCity=:departureCity AND arrivalCity = :arrivalCity AND dateOfDeparture=:dateOfDeparture")
	List<Flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to,@Param("dateOfDeparture") Date departureDate);
}
