package com.bae.persistence.repository;

public interface StaffRepository {

	// C
	String addStaffMember(String staffJSON);

	// R
	String getAllStaff();

	String getAStaffMember(int id);

	// U
	String updateStaff(String staffJSON, int id);

	// D
	String deleteStaffMember(int id);
}
