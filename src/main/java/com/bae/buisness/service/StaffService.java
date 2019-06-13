package com.bae.buisness.service;

public interface StaffService {

	// C
	String addStaffMember(String classroom);

	// R
	String getAllStaff();

	String getAStaffMember(int id);

	// U
	String updateStaff(String classroom, int id);

	// D
	String deleteStaffMember(int id);

}
