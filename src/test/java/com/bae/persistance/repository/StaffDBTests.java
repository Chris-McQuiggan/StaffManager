package com.bae.persistance.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.domain.Staff;
import com.bae.persistence.repository.StaffDBRepository;
import com.bae.util.Constant;

@RunWith(MockitoJUnitRunner.class)
public class StaffDBTests {

	@InjectMocks
	private StaffDBRepository repo;

	@Mock
	private Query query;

	@Mock
	private EntityManager em;

	@Before
	public void setup() {
		repo.setManager(em);
		repo.setUtil(Constant.util);
	}

	@Test
	public void testGetAllStaff() {
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		List<Staff> staff = new ArrayList<Staff>();
		staff.add(Constant.staff1);
		Mockito.when(query.getResultList()).thenReturn(staff);
		Assert.assertEquals("[" + Constant.jSONStaff1 + "]", repo.getAllStaff());
	}

	@Test
	public void testGetAllStaffEmpty() {
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		List<Staff> staff = new ArrayList<Staff>();
		Mockito.when(query.getResultList()).thenReturn(staff);
		Assert.assertEquals("[]", repo.getAllStaff());
	}

	@Test
	public void testGetAStaffMember() {
		Mockito.when(em.find(Staff.class, 1)).thenReturn(Constant.staff1);
		Assert.assertEquals(Constant.jSONStaff1, repo.getAStaffMember(1));
	}

	@Test
	public void testDeleteStaffMember() {
		String reply = repo.deleteStaffMember(1);
		Assert.assertEquals("{\"message\":\"Staff Member Deleted\"}", reply);
	}

	@Test
	public void testAddStaffMember() {
		String reply = repo.addStaffMember(Constant.jSONStaff1);
		Assert.assertEquals(Constant.jSONStaff1, reply);
	}

	@Test
	public void testUpdateStaff() {
		Mockito.when(em.find(Staff.class, 1)).thenReturn(Constant.staff3);
		Assert.assertEquals(Constant.jSONStaff2, repo.updateStaff(Constant.jSONStaff2, 1));
	}
}
