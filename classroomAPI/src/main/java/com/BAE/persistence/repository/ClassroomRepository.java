package com.BAE.persistence.repository;

public interface ClassroomRepository {

	String getAllClassMembers();
	
	String addTrainer(String pTrainer);
	
	String addTrainee(String pTrainee);
	
	String deleteClassMember(Long id);
}