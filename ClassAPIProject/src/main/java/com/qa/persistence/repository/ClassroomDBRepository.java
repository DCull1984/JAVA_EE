package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Register;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepository implements ClassRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	public String getAllClassMembers() 
	{
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Register> classroom = (Collection<Register>) query.getResultList();
		return util.getJSONForObject(classroom);
	}

	@Transactional(REQUIRED)
	public String addTrainer(String trainer) {
		Register aTrainer = util.getObjectForJSON(trainer, Register.class);
		manager.persist(aTrainer);
		return "{\"message\": \"Trainer has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String addTrainee(String trainee) {
		Register aTrainee = util.getObjectForJSON(trainee, Register.class);
		manager.persist(aTrainee);
		return "{\"message\": \"Trainee has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String deleteClassMember(Long id) {
		Register memberInDB = findAccount(id);
		if (memberInDB != null) {
			manager.remove(memberInDB);
		}
		return "{\"message\": \"Class member sucessfully deleted\"}";
	}

	private Register findAccount(Long id) {
		return manager.find(Register.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
