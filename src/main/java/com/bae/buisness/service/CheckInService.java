package com.bae.buisness.service;

public interface CheckInService {

	// C
	String NewCheckIn(String classroom);

	// R
	String getAllCheckIns();

	String getACheckIn(int id);

	// U
	String CheckOut(String classroom, int id);

	// Never Delete!

}
