package com.bae.buisness.service;

public interface CheckInService {

	// C
	String newCheckIn(String checkInJSON);

	// R
	String getAllCheckIns();

	String getCheckedIn();

	String getACheckIn(int id);

	// U
	String checkOut(String checkOutJSON, int id);

	// Never Delete!

}
