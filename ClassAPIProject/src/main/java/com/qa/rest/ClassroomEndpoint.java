package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.qa.business.service.ClassService;

@Path("/classroom")
//class i want to activate
public class ClassroomEndpoint {
	
	@Inject
	private ClassService service;

	@Path("/getAllClassMembers")
	// method that i want to activate
	@GET
	@Produces({ "application/json" })
	public String getAllClassMember() {
		return service.getAllClassMembers();
	}

	@Path("/addTrainer")
	@POST
	@Produces({ "application/json" })
	public String addTrainer(String trainer) {
		return service.addTrainer(trainer);
	}
	
	@Path("/addTrainee")
	@POST
	@Produces({"application/json"})
	public String addTrainee(String pTrainee)
	{
		return service.addTrainee(pTrainee);
	}

	@Path("/deleteClassMember/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassMember(@PathParam("id") Long id) {
		return service.deleteClassMember(id);
	}

	public void setService(ClassService service) {
		this.service = service;
	}

}
