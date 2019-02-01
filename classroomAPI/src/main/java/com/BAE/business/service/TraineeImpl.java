package com.BAE.business.service;

import javax.inject.Inject;

import com.BAE.persistence.repository.TraineeRepository;

public class TraineeImpl implements Trainee
{

	@Inject 
	private TraineeRepository tRepo;
	
	@Override
	public String getAllClassMembers() 
	{
		return tRepo.getAllTrainees();
	}

	@Override
	public String addTrainee(String pTrainee) 
	{
		return tRepo.addTrainee(pTrainee);
	}

	@Override
	public String deleteTrainee(Long id) 
	{
		return tRepo.deleteTrainee(id);
	}

	public void setRepo(TraineeRepository repo) {
		this.tRepo = repo;
	}

}
