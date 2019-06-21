package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.bae.persistence.domain.Staff;
import com.bae.util.JSONUtil;

@Alternative
public class StaffMapRepository implements StaffRepository {

	private Map<Integer, Staff> staffMap = new HashMap<>();

	private JSONUtil util = new JSONUtil();

	public Map<Integer, Staff> getStaffMap() {
		return staffMap;
	}

	@Override
	public String addStaffMember(String staffJSON) {
		Staff newStaffMember = util.getObjectForJSON(staffJSON, Staff.class);
		staffMap.put(newStaffMember.getStaffID(), newStaffMember);
		return "Staff Member successfuly created";
	}

	@Override
	public String getAllStaff() {
		return util.getJSONForObject(staffMap);
	}

	@Override
	public String getAStaffMember(int id) {
		return util.getJSONForObject(staffMap.get(id));
	}

	@Override
	public String updateStaff(String staffJSON, int id) {
		Staff staffToUpdate = util.getObjectForJSON(staffJSON, Staff.class);
		staffMap.put(id, staffToUpdate);
		return "Staff Member successfully updated";
	}

	@Override
	public String deleteStaffMember(int id) {
		staffMap.remove((Integer) id);
		return "Staff Member successfully removed";
	}

}
