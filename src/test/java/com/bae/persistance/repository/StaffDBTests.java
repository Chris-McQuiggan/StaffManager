package com.bae.persistance.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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
	private TypedQuery<Staff> query;

	@Mock
	private EntityManager em;

	@Before
	public void setup() {
		repo.setManager(em);
		repo.setUtil(Constant.util);
	}

	@Ignore
	@Test
	public void testGetAllStaff() {
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		List<Staff> staff = new ArrayList<Staff>();
		staff.add(Constant.staff1);
		Mockito.when(query.getResultList()).thenReturn(staff);
		System.out.println(repo.getAllStaff());
		Assert.assertEquals(Constant.jSONStaff1, repo.getAllStaff());
	}
}
