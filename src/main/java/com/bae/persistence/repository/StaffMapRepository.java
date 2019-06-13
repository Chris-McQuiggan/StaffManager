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

	public Map<Integer, Staff> getClassMap() {
		return staffMap;
	}

	public void setClassMap(Map<Integer, Staff> classMap) {
		this.staffMap = classMap;
	}

	@Override
	public String addStaffMember(String staffJSON) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllStaff() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAStaffMember(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateStaff(String staffJSON, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteStaffMember(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
