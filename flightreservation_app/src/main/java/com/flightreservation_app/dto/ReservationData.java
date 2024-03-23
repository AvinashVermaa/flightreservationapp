package com.flightreservation_app.dto;

public class ReservationData {

	private String passengerFirstName;
	private String passengerLastName;
	private String passengerMiddleName;
	private String passengerEmail;
	private String passengerPhone;
	public String getPassengerFirstName() {
		return passengerFirstName;
	}
	public void setPassengerFirstName(String passengerFirstName) {
		this.passengerFirstName = passengerFirstName;
	}
	public String getPassengerLastName() {
		return passengerLastName;
	}
	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}
	public String getPassengerMiddleName() {
		return passengerMiddleName;
	}
	public void setPassengerMiddleName(String passengerMiddleName) {
		this.passengerMiddleName = passengerMiddleName;
	}
	public String getPassengerEmail() {
		return passengerEmail;
	}
	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}
	public String getPassengerPhone() {
		return passengerPhone;
	}
	public void setPassengerPhone(String passengerPhone) {
		this.passengerPhone = passengerPhone;
	}
	@Override
	public String toString() {
		return "ReservationData [passengerFirstName=" + passengerFirstName + ", passengerLastName=" + passengerLastName
				+ ", passengerMiddleName=" + passengerMiddleName + ", passengerEmail=" + passengerEmail
				+ ", passengerPhone=" + passengerPhone + "]";
	}
	public ReservationData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReservationData(String passengerFirstName, String passengerLastName, String passengerMiddleName,
			String passengerEmail, String passengerPhone) {
		super();
		this.passengerFirstName = passengerFirstName;
		this.passengerLastName = passengerLastName;
		this.passengerMiddleName = passengerMiddleName;
		this.passengerEmail = passengerEmail;
		this.passengerPhone = passengerPhone;
	}
	
	
}
