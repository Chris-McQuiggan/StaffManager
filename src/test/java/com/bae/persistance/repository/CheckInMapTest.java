package com.bae.persistance.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.domain.CheckIn;
import com.bae.persistence.repository.CheckInMapRepository;
import com.bae.util.Constant;

public class CheckInMapTest {
	private CheckInMapRepository cmr;

	@Before
	public void setup() {
		cmr = new CheckInMapRepository();
	}

	@Test
	public void getAllCheckInsTest() {
		assertEquals("{}", cmr.getAllCheckIns());
	}

	@Test
	public void getAllCheckInsTest2() {
		cmr.getCheckInMap().put(1, Constant.check1);
		assertEquals("{\"1\":" + Constant.jSONCheck1 + "}", cmr.getAllCheckIns());
	}

	@Test
	public void getCheckInTestNoMatch() {
		cmr.getCheckInMap().put(1, Constant.check1);
		assertEquals("null", cmr.getACheckIn(2));
	}

	@Test
	public void getCheckInTestMatch() {
		cmr.getCheckInMap().put(1, Constant.check1);
		assertEquals(Constant.jSONCheck1, cmr.getACheckIn(1));
	}

	@Test
	public void newCheckInTest1() {
		assertEquals(cmr.newCheckIn(Constant.jSONCheckIn1), Constant.jSONCheckIn1);
		assertEquals(cmr.getCheckInMap().size(), 1);
	}

	@Test
	public void checkOutTest() {
		cmr.getCheckInMap().put(4, Constant.checkIn1);
		assertEquals(Constant.jSONCheckInOut1, cmr.checkOut(Constant.jSONCheckOut1, 4));
		assertEquals("17:20", cmr.getCheckInMap().get(4).getTimeOut());
	}

	@Test
	public void getAllCheckedInTest() {
		cmr.getCheckInMap().put(1, Constant.check1);
		cmr.getCheckInMap().put(2, Constant.check2);
		cmr.getCheckInMap().put(3, Constant.check3);
		cmr.getCheckInMap().put(4, Constant.checkIn1);
		assertEquals("{\"1\":" + Constant.jSONCheckIn1 + "}", cmr.getCheckedIn());
	}

	@Test
	public void jsonStringToCheckInConversionTest() {
		String stringToTest = Constant.jSONCheck1;
		CheckIn testCheckIn = Constant.util.getObjectForJSON(stringToTest, CheckIn.class);
		assertEquals(Constant.check1.getLogID(), testCheckIn.getLogID());
	}

	@Test
	public void checkInConversionToJSONTest() {
		String jsonCheck = Constant.jSONCheck1;
		String stringToTest = Constant.util.getJSONForObject(Constant.check1);
		assertEquals(jsonCheck, stringToTest);

	}

	@Test
	public void deleteCheckInTest() {
		cmr.getCheckInMap().put(1, Constant.check1);
		cmr.deleteCheckIn(1);
		assertEquals(false, cmr.getCheckInMap().containsKey(1));
	}

}
