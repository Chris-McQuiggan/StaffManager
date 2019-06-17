package com.bae.buisness.service;

public interface CheckInService {

	// C
	String newCheckIn(String classroom);

	// R
	String getAllCheckIns();

	String getCheckedIn();

	String getACheckIn(int id);

	// U
	String checkOut(String classroom, int id);

	// Never Delete!

}
