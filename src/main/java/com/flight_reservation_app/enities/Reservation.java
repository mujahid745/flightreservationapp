package com.flight_reservation_app.enities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity {
    
	private boolean checkedIn;
	private int numbersOfBags;
	@OneToOne
	private Passenger passenger;
	@OneToOne
	private Flight flight;
	public boolean isCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	public int getNumbersOfBags() {
		return numbersOfBags;
	}
	public void setNumbersOfBags(int numbersOfBags) {
		this.numbersOfBags = numbersOfBags;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	
}
