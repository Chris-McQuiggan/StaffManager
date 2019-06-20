package com.bae.buisness.service;

import javax.inject.Inject;

import com.bae.persistence.repository.CheckInRepository;

public class CheckInServiceImpl implements CheckInService {
	@Inject
	private CheckInRepository repo;

	@Override
	public String newCheckIn(String checkIn) {
		return repo.newCheckIn(checkIn);
	}

	@Override
	public String getAllCheckIns() {
		return repo.getAllCheckIns();
	}

	@Override
	public String getCheckedIn() {
		return repo.getCheckedIn();
	}

	@Override
	public String getACheckIn(int id) {
		return repo.getACheckIn(id);
	}

	@Override
	public String checkOut(String checkOut, int id) {
		return repo.checkOut(checkOut, id);
	}

	@Override
	public String deleteCheckIn(int id) {
		return repo.deleteCheckIn(id);
	}

}
