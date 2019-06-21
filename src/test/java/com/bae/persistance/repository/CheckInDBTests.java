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

import com.bae.persistence.domain.CheckIn;
import com.bae.persistence.repository.CheckInDBRepo;
import com.bae.util.Constant;

@RunWith(MockitoJUnitRunner.class)
public class CheckInDBTests {

	@InjectMocks
	private CheckInDBRepo repo;

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
	public void testGetAllCheckIns() {
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		List<CheckIn> checkIn = new ArrayList<>();
		checkIn.add(Constant.check1);
		Mockito.when(query.getResultList()).thenReturn(checkIn);
		Assert.assertEquals("[" + Constant.jSONCheck1 + "]", repo.getAllCheckIns());
	}

	@Test
	public void testGetAllCheckInsEmpty() {
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		List<CheckIn> checkIn = new ArrayList<>();
		Mockito.when(query.getResultList()).thenReturn(checkIn);
		Assert.assertEquals("[]", repo.getAllCheckIns());
	}

	@Test
	public void testGetACheckIn() {
		Mockito.when(em.find(CheckIn.class, 1)).thenReturn(Constant.check1);
		Assert.assertEquals(Constant.jSONCheck1, repo.getACheckIn(1));
	}

	@Test
	public void testDeleteCheckIn() {
		String reply = repo.deleteCheckIn(1);
		Assert.assertEquals("{\"message\":\"Log Deleted\"}", reply);
	}

	@Test
	public void testNewCheckIn() {
		String reply = repo.newCheckIn(Constant.jSONCheck1);
		Assert.assertEquals(Constant.jSONCheck1, reply);
	}

	@Test
	public void testCheckOut() {
		Mockito.when(em.find(CheckIn.class, 4)).thenReturn(Constant.checkIn1);
		Mockito.when(em.getReference(CheckIn.class, 4)).thenReturn(Constant.checkInOut1);
		Assert.assertEquals(Constant.jSONCheckInOut1, repo.checkOut(Constant.jSONCheckOut1, 4));
	}

	@Test
	public void testCheckOut2() {
		Mockito.when(em.find(CheckIn.class, 4)).thenReturn(null);
		Mockito.when(em.getReference(CheckIn.class, 4)).thenReturn(null);
		Assert.assertEquals("null", repo.checkOut(Constant.jSONCheckOut1, 4));
	}

	@Test
	public void testGetCheckedIn() {
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		List<CheckIn> checkIn = new ArrayList<>();
		checkIn.add(Constant.checkIn2);
		checkIn.add(Constant.check1);
		Mockito.when(query.getResultList()).thenReturn(checkIn);
		Assert.assertEquals("{\"1\":" + Constant.jSONCheckIn2 + "}", repo.getCheckedIn());

	}
}
