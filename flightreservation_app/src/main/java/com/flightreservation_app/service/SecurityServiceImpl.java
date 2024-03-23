package com.flightreservation_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {
	
	@Autowired
	private UserDetailsService userDetails;

	@Autowired
	private AuthenticationManager manager;
	
	@Override
	public boolean login(String userName, String password) {
		UserDetails userDetails1 = userDetails.loadUserByUsername(userName);
		
		UsernamePasswordAuthenticationToken token = new 
				UsernamePasswordAuthenticationToken(userDetails1, password, userDetails1.getAuthorities());
		
		manager.authenticate(token);
		
		boolean result = token.isAuthenticated();
		
		if(result) {
			SecurityContextHolder.getContext().setAuthentication(token);
		}
		
		return result;
	}

}
