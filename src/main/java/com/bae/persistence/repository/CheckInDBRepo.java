package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.bae.persistence.domain.CheckIn;
import com.bae.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class CheckInDBRepo implements CheckInRepository {

	@Inject
	JSONUtil util;

	@PersistenceContext(unitName = "primary")
	EntityManager em;

	@Transactional(TxType.REQUIRED)
	@Override
	public String newCheckIn(String checkInJSON) {
		CheckIn checkIn1 = util.getObjectForJSON(checkInJSON, CheckIn.class);
		em.persist(checkIn1);
		return checkInJSON;
	}

	@Override
	public String getAllCheckIns() {
		Query query = null;
		query = em.createQuery("SELECT c FROM CheckIn c");
		List<CheckIn> checkList = query.getResultList();
		return util.getJSONForObject(checkList);
	}

	@Override
	public String getCheckedIn() {
		Query query = null;
		query = em.createQuery("SELECT c FROM CheckIn c");
		List<CheckIn> checkList = query.getResultList();
		int j = 1;
		Map<Integer, CheckIn> checkedInMap = new HashMap<>();
		for (int i = 0; i < checkList.size(); i++) {
			if (checkList.get(i).getTimeOut() == null) {
				checkedInMap.put(j, checkList.get(i));
				j++;
			}
		}
		return util.getJSONForObject(checkedInMap);
	}

	@Override
	public String getACheckIn(int id) {
		return util.getJSONForObject(em.find(CheckIn.class, id));
	}

	@Transactional(TxType.REQUIRED)
	@Override
	public String checkOut(String checkOutJSON, int id) {
		CheckIn checkIn = util.getObjectForJSON(checkOutJSON, CheckIn.class);
		CheckIn checkInToUpdate = em.find(CheckIn.class, id);

		if (checkInToUpdate != null) {
			checkInToUpdate.setTimeOut(checkIn.getTimeOut());
			checkInToUpdate.setHours(checkIn.getHours());
			em.persist(checkInToUpdate);
		}
		return util.getJSONForObject(em.getReference(CheckIn.class, id));
	}

	public void setManager(EntityManager manager) {
		this.em = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	@Transactional(TxType.REQUIRED)
	@Override
	public String deleteCheckIn(int id) {
		CheckIn check = em.getReference(CheckIn.class, id);
		em.remove(check);
		return "{\"message\":\"Log Deleted\"}";
	}

}