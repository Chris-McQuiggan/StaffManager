package com.bae.persistence.repository;

public interface CheckInRepository {

	// C
	String NewCheckIn(String classroom);

	// R
	String getAllCheckIns();

	String getCheckedIn();

	String getACheckIn(int id);

	// U
	String CheckOut(String classroom, int id);

	// Never Delete!

}
