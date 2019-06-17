package com.bae.persistence.repository;

public interface CheckInRepository {

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
