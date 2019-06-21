package com.bae.buisness.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.repository.StaffRepository;
import com.bae.util.Constant;

@RunWith(MockitoJUnitRunner.class)
public class StaffServiceTests {

	@InjectMocks
	private StaffServiceImpl checkRepo;

	@Mock
	private StaffRepository repo;

	@Test
	public void testGetAllStaff() {
		Mockito.when(repo.getAllStaff()).thenReturn(Constant.jSONStaff1);
		Assert.assertEquals(Constant.jSONStaff1, checkRepo.getAllStaff());
	}

	@Test
	public void testGetAStaffMember() {
		Mockito.when(repo.getAStaffMember(1)).thenReturn(Constant.jSONStaff1);
		Assert.assertEquals(Constant.jSONStaff1, checkRepo.getAStaffMember(1));
	}

	@Test
	public void testDeleteStaffMember() {
		Mockito.when(repo.deleteStaffMember(1)).thenReturn("{\"message\":\"Staff Member Deleted\"}");
		Assert.assertEquals("{\"message\":\"Staff Member Deleted\"}", checkRepo.deleteStaffMember(1));
	}

	@Test
	public void testAddStaffMember() {
		Mockito.when(repo.addStaffMember(Constant.jSONStaff2)).thenReturn(Constant.jSONStaff2);
		Assert.assertEquals(Constant.jSONStaff2, checkRepo.addStaffMember(Constant.jSONStaff2));
	}

	@Test
	public void testUpdateStaff() {
		Mockito.when(repo.updateStaff(Constant.jSONStaff1, 4)).thenReturn(Constant.jSONStaff1);
		Assert.assertEquals(Constant.jSONStaff1, checkRepo.updateStaff(Constant.jSONStaff1, 4));
	}
}
