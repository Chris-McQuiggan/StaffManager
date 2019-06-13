package com.bae.buisness.service;

public interface StaffService {

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
