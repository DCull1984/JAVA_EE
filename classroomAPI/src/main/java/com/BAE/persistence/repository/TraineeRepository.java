package com.BAE.persistence.repository;

public interface TraineeRepository 
{
	String getAllTrainees();
			
	String addTrainee(String pTrainee);
	
	String deleteTrainee(Long id);
}
