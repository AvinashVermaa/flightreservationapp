package com.flightreservation_app.config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired
	private UserDetailsService userDetails;
	
	@Bean
	AuthenticationManager authManager() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userDetails);
		auth.setPasswordEncoder(passwordEncoder());
		
		return new ProviderManager(auth);
	}
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http.authorizeRequests().antMatchers("/admin/addFlight").hasRole("ADMIN")
				.antMatchers("/findFlights", "/displayFlights", "/showCompleteReservation*", "/completeReservation",
						"/completeReservation")
				.authenticated()
				.antMatchers("/showRegUserForm", "/login/registerUser", "/registerUser", "/login/registerUser",
						"/showLoginPage", "/login/login", "/checkCred","/index.html","/updatereservation","/reservation")
				.permitAll().and().csrf().disable().
				build();

	}
}






/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UserDetailsService userDetails;

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetails);
        authProvider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(authProvider);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/admin/addFlight").hasRole("ADMIN")
            .antMatchers("/findFlights", "/displayFlights", "/showCompleteReservation*", "/completeReservation",
                         "/showRegUserForm", "/login/registerUser", "/registerUser", "/showLoginPage",
                         "/login/login", "/checkCred", "/index.html", "/updatereservation", "/reservation/**")
            .permitAll()
            .anyRequest().authenticated()
            .and()
            .csrf().disable();
        return http.build();
    }
}
*/