package com.bae.persistance.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.domain.Staff;
import com.bae.persistence.repository.StaffMapRepository;
import com.bae.util.Constant;

public class StaffMapTest {
	private StaffMapRepository smr;

	@Before
	public void setup() {
		smr = new StaffMapRepository();
	}

	@Test
	public void getAllStaffTest() {
		assertEquals("{}", smr.getAllStaff());
	}

	@Test
	public void getAllSatffTest2() {
		smr.getStaffMap().put(1, Constant.staff1);
		assertEquals("{\"1\":" + Constant.jSONStaff1 + "}", smr.getAllStaff());
	}

	@Test
	public void getStaffTestNoMatch() {
		smr.getStaffMap().put(1, Constant.staff1);
		assertEquals("null", smr.getAStaffMember(2));
	}

	@Test
	public void getStaffTestMatch() {
		smr.getStaffMap().put(1, Constant.staff1);
		assertEquals(Constant.jSONStaff1, smr.getAStaffMember(1));
	}

	@Test
	public void addStaffTest1() {
		assertEquals(smr.addStaffMember(Constant.jSONStaff1), "Staff Member successfuly created");
		assertEquals(smr.getStaffMap().size(), 1);
	}

	@Test
	public void removeStaffTest() {
		smr.getStaffMap().put(1, Constant.staff1);
		smr.deleteStaffMember(1);
		assertEquals(false, smr.getStaffMap().containsKey(1));

	}

	@Test
	public void remove2StaffTest() {
		smr.getStaffMap().put(1, Constant.staff1);
		smr.getStaffMap().put(2, Constant.staff2);
		smr.deleteStaffMember(1);
		assertEquals(false, smr.getStaffMap().containsKey((Integer) 1));
		smr.deleteStaffMember(2);
		assertEquals(false, smr.getStaffMap().containsKey((Integer) 2));
	}

	@Test
	public void updateStaffTest() {
		smr.getStaffMap().put(1, Constant.staff1);
		smr.updateStaff(Constant.jSONStaff2, 1);
		assertEquals("Chester", smr.getStaffMap().get(1).getFirstName());
	}

	@Test
	public void jsonStringToStaffConversionTest() {
		String stringToTest = Constant.jSONStaff1;
		Staff testStaff = Constant.util.getObjectForJSON(stringToTest, Staff.class);
		assertEquals(Constant.staff1.getStaffID(), testStaff.getStaffID());
	}

	@Test
	public void staffConversionToJSONTest() {
		String jsonStaff = Constant.jSONStaff1;
		String stringToTest = Constant.util.getJSONForObject(Constant.staff1);
		assertEquals(jsonStaff, stringToTest);

	}
}
