package com.flightreservation_app.service;

import org.springframework.stereotype.Service;

@Service
public interface SecurityService {

	public boolean login(String userName,String password);
}
