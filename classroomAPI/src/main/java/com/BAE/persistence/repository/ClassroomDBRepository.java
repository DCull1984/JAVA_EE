package com.BAE.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.BAE.persistence.domain.ClassMembers;
import com.BAE.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepository implements ClassroomRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAllClassMembers() {
		Query query = manager.createQuery("SELECT a FROM ClassMembers a");
		List<ClassMembers> peopleInClass = query.getResultList();
		return util.getJSONForObject(peopleInClass);
	}

	@Transactional(REQUIRED)
	public String addTrainer(String pTrainer) {
		ClassMembers aTrainer = util.getObjectForJSON(pTrainer, ClassMembers.class);
		manager.persist(aTrainer);
		return "{\"message\": \"Trainer has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String addTrainee(String pTrainee) {
		ClassMembers aTrainee = util.getObjectForJSON(pTrainee, ClassMembers.class);
		manager.persist(aTrainee);
		return "{\"message\": \"Trainee has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteClassMember(Long id) {
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
