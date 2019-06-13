package com.bae.StaffManager;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.domain.Staff;
import com.bae.persistence.repository.StaffMapRepository;
import com.bae.util.JSONUtil;

public class StaffMapTest {

	private StaffMapRepository smr;
	private JSONUtil util = new JSONUtil();
	private Staff staff1 = new Staff(1, "Matt", "Hunt", "mat.hunt@mail.com", "Trainer", 2);
	private Staff staff2 = new Staff(2, "Chester", "Gardner", "chester@mail.com", "Trainer", 2);
	private Staff staff3 = new Staff(3, "Louis", "Simth", "Louis@gmail.com", "Consoltant", 4);
	private String jSONStaff1 = "{\"staffID\":1,\"firstName\":\"Matt\"}";
	private String jSONClass2 = "{\"staffID\":2,\"firstName\":\"Chester\"}";

	@Before
	public void setup() {
		smr = new StaffMapRepository();
	}

	@Test
	public void getAllClassroomsTest() {
		assertEquals("{}", smr.getAllStaff());
	}

	@Test
	public void getAllTraineesTest2() {
		smr.getStaffMap().put(1, staff1);
		System.out.println(smr.getAllStaff());
		assertEquals("{\"1\":" + jSONStaff1 + "}", smr.getAllStaff());
	}

	@Test
	public void getClassTestNoMatch() {
		smr.getStaffMap().put(1, staff1);
		assertEquals("null", smr.getAStaffMember(2));
	}

	@Test
	public void getClassTestMatch() {
		smr.getStaffMap().put(1, staff1);
		assertEquals(jSONStaff1, smr.getAStaffMember(1));
	}

	@Test
	public void addClassTest1() {
		assertEquals(smr.addStaffMember(jSONStaff1), "Staff successfuly created");
		assertEquals(smr.getStaffMap().size(), 1);
	}

	@Test
	public void removeClassTest() {
		smr.getStaffMap().put(1, staff1);
		smr.deleteStaffMember(1);
		assertEquals(false, smr.getStaffMap().containsKey(1));

	}

	@Test
	public void remove2ClassTest() {
		smr.getStaffMap().put(1, staff1);
		smr.getStaffMap().put(2, staff2);
		smr.deleteStaffMember(1);
		assertEquals(false, smr.getStaffMap().containsKey((Integer) 1));
		smr.deleteStaffMember(2);
		assertEquals(false, smr.getStaffMap().containsKey((Integer) 2));
	}

	@Test
	public void updateAccountTest() {
		smr.getStaffMap().put(1, staff1);
		smr.updateStaff(jSONClass2, 1);
		assertEquals("Chester", smr.getStaffMap().get(1).getFirstName());
	}

	@Test
	public void jsonStringToClasroomConversionTest() {
		String stringToTest = jSONStaff1;
		Staff testStaff = util.getObjectForJSON(stringToTest, Staff.class);
		assertEquals(staff1.getStaffID(), testStaff.getStaffID());
	}

	@Test
	public void staffConversionToJSONTest() {
		String jsonStaff = jSONStaff1;
		String stringToTest = util.getJSONForObject(staff1);
		assertEquals(jsonStaff, stringToTest);

	}
}
