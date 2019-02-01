package com.BAE.business.service;

public interface Classroom {

	String getAllClassMembers();

	String addTrainer(String pTrainer);
	
	String addTrainee(String pTrainee);

	String deleteClassMember(Long id);

}