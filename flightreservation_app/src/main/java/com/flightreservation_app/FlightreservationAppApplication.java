package com.flightreservation_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class FlightreservationAppApplication{

	public static void main(String[] args) {
		SpringApplication.run(FlightreservationAppApplication.class, args);
	}

}
