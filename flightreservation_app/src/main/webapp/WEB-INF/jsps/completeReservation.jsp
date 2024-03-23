<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete Reservation</title>
</head>
<body>
	<h2>Complete Reservation Page</h2>
	
	Operating Airline : ${flight.operatingAirlines}<br/>
	Departure City : ${flight.departureCity}<br/>
	Arrival City : ${flight.arrivalCity}<br/>
	Estimated Departure Date Time : ${flight.estimatedDepartureTime}<br/>
	
	<form action="completeReservation" method="post">
		<pre>
			First Name : <input type="text" name="passengerFirstName"/>
			Last Name : <input type="text" name="passengerLastName"/>
			Middle Name : <input type="text" name="passengerMiddleName"/>
			Email : <input type="text" name="passengerEmail"/>
			Phone : <input type="text" name="passengerPhone"/>
			
			<h2>Card Details</h2>
			Name on the card : <input type="text" name="nameOnTheCard"/>
			Card Number : <input type="text" name="cardNumber"/>
			Expiry Date : <input type="text" name="expiryDate"/>
			CVV : <input type="password" name="cvv"/>
			
			<input type="hidden" name="flightId" value="${flight.id}"/>
			
			<input type="submit" value="confirm"/>
			
		</pre>
	</form>
	
</body>
</html>