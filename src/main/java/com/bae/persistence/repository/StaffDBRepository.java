package com.bae.persistence.repository;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.bae.persistence.domain.Staff;
import com.bae.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class StaffDBRepository implements StaffRepository {

	@Inject
	JSONUtil util;

	@PersistenceContext(unitName = "primary")
	EntityManager em;

	@Transactional(TxType.REQUIRED)
	@Override
	public String addStaffMember(String staffJSON) {
		Staff staff1 = util.getObjectForJSON(staffJSON, Staff.class);
		em.persist(staff1);
		return staffJSON;
	}

	@Override
	public String getAllStaff() {
		TypedQuery<Staff> query = null;
		query = em.createQuery("SELECT s FROM Staff s", Staff.class);
		List<Staff> staffList = query.getResultList();
		return util.getJSONForObject(staffList);
	}

	@Override
	public String getAStaffMember(int id) {
		return util.getJSONForObject(em.find(Staff.class, id));
	}

	@Transactional(TxType.REQUIRED)
	@Override
	public String updateStaff(String staffJSON, int id) {
		Staff staff1 = util.getObjectForJSON(staffJSON, Staff.class);
		Staff staffToUpdate = em.getReference(Staff.class, id);
		if (staffToUpdate != null) {
			staffToUpdate.setFirstName(staff1.getFirstName());
			staffToUpdate.setLastName(staff1.getLastName());
			staffToUpdate.setEmail(staff1.getEmail());
			staffToUpdate.setJobRole(staff1.getJobRole());
			staffToUpdate.setPayTier(staff1.getPayTier());
			em.persist(staffToUpdate);
		}
		return staffJSON;
	}

	@Transactional(TxType.REQUIRED)
	@Override
	public String deleteStaffMember(int id) {
		Staff staff1 = em.getReference(Staff.class, id);
		em.remove(staff1);
		return "{\"message\":\"Staff Member Deleted\"}";
	}

	public void setManager(EntityManager manager) {
		this.em = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
