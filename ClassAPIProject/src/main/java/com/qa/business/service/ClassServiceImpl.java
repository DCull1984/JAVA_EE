package com.qa.business.service;

import javax.inject.Inject;

//import org.apache.log4j.Logger;

import com.qa.persistence.repository.ClassRepository;

public class ClassServiceImpl implements ClassService {
	

	@Inject
	private ClassRepository repository;

	public String getAllClassMembers() 
	{
		return repository.getAllClassMembers();
	}

	public String addTrainer(String pTrainer) 
	{
		return repository.addTrainer(pTrainer);
	}

	public String addTrainee(String pTrainee) 
	{
		return repository.addTrainee(pTrainee);
	}

	public String deleteClassMember(Long pId) 
	{
		return repository.deleteClassMember(pId);
	}
	
	public void setRepository(ClassRepository pRepository)
	{
		this.repository = pRepository;
	}
}
