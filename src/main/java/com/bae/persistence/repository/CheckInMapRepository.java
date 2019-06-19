package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.bae.persistence.domain.CheckIn;
import com.bae.util.JSONUtil;

@Alternative
public class CheckInMapRepository implements CheckInRepository {

	private Map<Integer, CheckIn> checkInMap = new HashMap<>();

	private JSONUtil util = new JSONUtil();

	public Map<Integer, CheckIn> getCheckInMap() {
		return checkInMap;
	}

	// public void setCheckInMap(Map<Integer, CheckIn> checkInMap) {
	// this.checkInMap = checkInMap;
	// }

	@Override
	public String newCheckIn(String checkInJSON) {
		CheckIn newCheckIn = util.getObjectForJSON(checkInJSON, CheckIn.class);
		checkInMap.put(newCheckIn.getLogID(), newCheckIn);
		return checkInJSON;
	}

	@Override
	public String getAllCheckIns() {
		return util.getJSONForObject(checkInMap);
	}

	@Override
	public String getCheckedIn() {
		Map<Integer, CheckIn> checkedInMap = new HashMap<>();
		int j = 1;
		for (int i = 1; i <= checkInMap.size(); i++) {
			if (checkInMap.get(i).getTimeOut() == null) {
				checkedInMap.put(j, checkInMap.get(i));
				j++;
			}
		}
		String checkedIn = util.getJSONForObject(checkedInMap);
		return checkedIn;
	}

	@Override
	public String getACheckIn(int id) {
		return util.getJSONForObject(checkInMap.get(id));
	}

	@Override
	public String checkOut(String checkOutJSON, int id) {
		CheckIn checkToUpdate = util.getObjectForJSON(checkOutJSON, CheckIn.class);
		checkToUpdate.setTimeIn(checkInMap.get(id).getTimeIn());
		checkToUpdate.setLogID(id);
		checkToUpdate.setStaffID(checkInMap.get(id).getStaffID());
		checkInMap.replace(id, checkToUpdate);
		return util.getJSONForObject(checkInMap.get(id));
	}

}
