package com.flightreservation_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flightreservation_app.entity.User;
import com.flightreservation_app.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(username);

		org.springframework.security.core.userdetails.User user1 = new org.springframework.security.core.userdetails.User(
				username, user.getPassword(), user.getRoles());

		if (user == null) {
			throw new UsernameNotFoundException("user is not found with username : " + username);
		} else {
			return user1;
		}
	}

}
