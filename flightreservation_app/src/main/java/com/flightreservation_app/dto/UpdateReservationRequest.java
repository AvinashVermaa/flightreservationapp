package com.flightreservation_app.dto;

public class UpdateReservationRequest {

	private int id;
	private boolean checkedIn;
	private int numberOfBags;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	public int getNumberOfBags() {
		return numberOfBags;
	}
	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}
	@Override
	public String toString() {
		return "UpdateReservationRequest [id=" + id + ", checkedIn=" + checkedIn + ", numberOfBags=" + numberOfBags
				+ "]";
	}
	public UpdateReservationRequest(int id, boolean checkedIn, int numberOfBags) {
		super();
		this.id = id;
		this.checkedIn = checkedIn;
		this.numberOfBags = numberOfBags;
	}
	public UpdateReservationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
