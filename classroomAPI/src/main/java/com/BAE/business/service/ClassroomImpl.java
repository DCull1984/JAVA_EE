package com.BAE.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.BAE.persistence.repository.ClassroomRepository;

public class ClassroomImpl implements Classroom {
	
	
	@Inject
	private ClassroomRepository repository;

	public String getAllClassMembers() {
		return repository.getAllClassMembers();
	}

	public String addTrainer(String pTrainer) {
		return repository.addTrainer(pTrainer);
	}
	
	public String addTrainee(String pTrainee) {
		return repository.addTrainer(pTrainee);
	}

	public String deleteClassMember(Long id) {
		return repository.deleteClassMember(id);
	}

	public void setRepo(ClassroomRepository repo) {
		this.repository = repo;
	}

}
