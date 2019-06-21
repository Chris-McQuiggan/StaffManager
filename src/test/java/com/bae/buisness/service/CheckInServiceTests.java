package com.bae.buisness.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.repository.CheckInRepository;
import com.bae.util.Constant;

@RunWith(MockitoJUnitRunner.class)
public class CheckInServiceTests {

	@InjectMocks
	private CheckInServiceImpl checkRepo;

	@Mock
	private CheckInRepository repo;

	@Test
	public void testGetAllCheckIns() {
		Mockito.when(repo.getAllCheckIns()).thenReturn(Constant.jSONCheck1);
		Assert.assertEquals(Constant.jSONCheck1, checkRepo.getAllCheckIns());
	}

	@Test
	public void testGetACheckIn() {
		Mockito.when(repo.getACheckIn(1)).thenReturn(Constant.jSONCheck1);
		Assert.assertEquals(Constant.jSONCheck1, checkRepo.getACheckIn(1));
	}

	@Test
	public void testDeleteCheckIn() {
		Mockito.when(repo.getCheckedIn()).thenReturn("{\"message\":\"Log Deleted\"}");
		Assert.assertEquals("{\"message\":\"Log Deleted\"}", checkRepo.getCheckedIn());
	}

	@Test
	public void testNewCheckIn() {
		Mockito.when(repo.newCheckIn(Constant.jSONCheckIn1)).thenReturn(Constant.jSONCheckIn1);
		Assert.assertEquals(Constant.jSONCheckIn1, checkRepo.newCheckIn(Constant.jSONCheckIn1));
	}

	@Test
	public void testCheckOut() {
		Mockito.when(repo.checkOut(Constant.jSONCheckInOut1, 4)).thenReturn(Constant.jSONCheckInOut1);
		Assert.assertEquals(Constant.jSONCheckInOut1, checkRepo.checkOut(Constant.jSONCheckInOut1, 4));
	}

	@Test
	public void testGetCheckedIn() {
		Mockito.when(repo.deleteCheckIn(1)).thenReturn(Constant.jSONCheckIn1);
		Assert.assertEquals(Constant.jSONCheckIn1, checkRepo.deleteCheckIn(1));
	}
}
