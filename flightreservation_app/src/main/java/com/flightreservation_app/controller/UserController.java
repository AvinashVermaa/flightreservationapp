package com.flightreservation_app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation_app.entity.User;
import com.flightreservation_app.repository.UserRepository;
import com.flightreservation_app.service.SecurityService;

@Controller
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SecurityService securityService;

	@RequestMapping("/showRegUserForm")
	public String showRegUserForm() {
		LOGGER.info("Inside showRegUserForm() : ");
		return "login/registerUser";
	}
	
	@Transactional
	@RequestMapping(value = "/registerUser",method=RequestMethod.POST)
	public String registerUser(@ModelAttribute User user,ModelMap modelMap) {
		
		LOGGER.info("Inside registerUser() User : "+user);
		User user1 = new User();
		user1.setFirstName(user.getFirstName());
		user1.setLastName(user.getLastName());
		user1.setEmail(user.getEmail());
		user1.setPassword(encoder.encode(user.getPassword()));
		
		User savedUser = userRepo.save(user1);
		
		modelMap.addAttribute("msg", "User saved successfully id : "+savedUser.getId());
		return "login/registerUser";
	}
	
	@RequestMapping(value = "/showLoginPage")
	public String showLoginPage() {
		LOGGER.info("Inside showLoginPage():");
		return "login/login";
	}
	
	@RequestMapping(value = "/checkCred",method=RequestMethod.POST)
	public String checkLoginCredentials(@RequestParam("userName") String userName,@RequestParam("password") String password,ModelMap model) {
		LOGGER.info("Inside checkLoginCredentials() UserName : "+userName+" and Password : "+password);
//		User user = userRepo.findByEmail(userName);
//		if(user.getPassword().equalsIgnoreCase(password)) {
//			LOGGER.info("Inside user.getPassword().equalsIgnoreCase(password) : User : "+user);
//			return "findFlights";
//		}
//		else {
//			model.addAttribute("msg", "Invalid UserName or password, please try again...");
//			return "login/login";
//		}
		
		boolean loginResult = securityService.login(userName, password);
		
		if(loginResult) {
			return "findFlights";
		}
		else {
			model.addAttribute("msg", "Invalid UserName or password, please try again...");
			return "login/login";
		}
		
	}
	
}
