package com.BAE.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.BAE.business.service.Classroom;

@Path("/classroom")

public class ClassroomEndpoint {
	
	@Inject
	private Classroom service;

	@Path("/peopleinclass")
	@GET
	@Produces({ "application/json" })
	public String getAllClassMembers() {
		return service.getAllClassMembers();
	}

	@Path("/addtrainer")
	@POST
	@Produces({ "application/json" })
	public String addTrainer(String pTrainer) {
		return service.addTrainer(pTrainer);
	}

	@Path("/addtrainee")
	@POST
	@Produces({ "application/json" })
	public String addTrainee(String pTrainee) {
		return service.addTrainee(pTrainee);
	}
	
	@Path("/deleteclassmember/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassMember(@PathParam("id") Long id) {
		return service.deleteClassMember(id);
	}

	public void setService(Classroom service) {
		this.service = service;
	}

}
