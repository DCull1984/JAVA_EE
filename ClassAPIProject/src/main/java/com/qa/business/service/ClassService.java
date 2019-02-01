package com.qa.business.service;

public interface ClassService {

	String getAllClassMembers();

	String addTrainer(String trainer);
	
	String addTrainee(String trainee);

	String deleteClassMember(Long id);

}