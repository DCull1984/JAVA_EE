package com.qa.persistence.repository;

public interface ClassRepository {

	String getAllClassMembers();
	
	String addTrainer(String trainer);
	
	String addTrainee(String trainee); 
	
	String deleteClassMember(Long id);

}