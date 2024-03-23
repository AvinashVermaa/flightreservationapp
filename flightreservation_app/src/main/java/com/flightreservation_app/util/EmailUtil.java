package com.flightreservation_app.util;

import java.io.File;

import org.springframework.stereotype.Component;

@Component
public interface EmailUtil {

	public void sendEmail(String to,File file) throws Exception;
}
