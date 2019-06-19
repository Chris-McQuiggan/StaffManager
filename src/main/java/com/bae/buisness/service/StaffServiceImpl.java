package com.bae.buisness.service;

import javax.inject.Inject;

import com.bae.persistence.repository.StaffRepository;

public class StaffServiceImpl implements StaffService {

	@Inject
	private StaffRepository repo;

	@Override
	public String addStaffMember(String staffJSON) {
		return repo.addStaffMember(staffJSON);
	}

	@Override
	public String getAllStaff() {
		return repo.getAllStaff();
	}

	@Override
	public String getAStaffMember(int id) {
		return repo.getAStaffMember(id);
	}

	@Override
	public String updateStaff(String staffJSON, int id) {
		return repo.updateStaff(staffJSON, id);
	}

	@Override
	public String deleteStaffMember(int id) {
		return repo.deleteStaffMember(id);
	}

}
