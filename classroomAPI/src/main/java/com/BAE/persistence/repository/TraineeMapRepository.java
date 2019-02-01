package com.BAE.persistence.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.BAE.persistence.domain.ClassMembers;
import com.BAE.util.JSONUtil;

public class TraineeMapRepository implements TraineeRepository 
{
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllTrainees() {
		Query query = manager.createQuery("SELECT a FROM ClassMembers a");
		List<ClassMembers> peopleInClass = query.getResultList();
		return util.getJSONForObject(peopleInClass);
	}

	@Override
	public String addTrainee(String pTrainee) {
		ClassMembers aTrainee = util.getObjectForJSON(pTrainee, ClassMembers.class);
		manager.persist(aTrainee);
		return "{\"message\": \"Trainee has been sucessfully added\"}";
	}

	@Override
	public String deleteTrainee(Long id) {
		ClassMembers memberInDB = findAccount(id);
		if (memberInDB != null) {
			manager.remove(memberInDB);
		}
		return "{\"message\": \"Member sucessfully deleted\"}";
	}
	
	private ClassMembers findAccount(Long id) {
		return manager.find(ClassMembers.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
