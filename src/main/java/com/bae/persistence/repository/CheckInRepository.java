package com.bae.persistence.repository;

public interface CheckInRepository {

	// C
	String newCheckIn(String checkInJSON);

	// R
	String getAllCheckIns();

	String getCheckedIn();

	String getACheckIn(int id);

	// U
	String checkOut(String checkOutJSON, int id);

	// Never Delete!
	String deleteCheckIn(int id);

}
