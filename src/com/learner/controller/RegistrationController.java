package com.learner.controller;



import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.learner.model.Registration;

import com.learner.service.RegistrationService;

import com.learner.service.implementation.RegistrationServiceImplementation;

@Path("/registration")
public class RegistrationController {
	
	private RegistrationService service = new RegistrationServiceImplementation();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createRegistration(Registration registration) {

		if (null == service.createRegistration(registration)) {
			return "Registration failed as username or email is not unique";
		} 
		return "Registration successful";
	}
	
	@GET
	@Path("/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getUsernameById(@PathParam("userId") int userId) {

		Registration user = service.getUsernameById(userId);
		return "username: "+user.getUsername()+ " , " +"email: " + user.getEmail();
		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getAllUsername() {

		List<Registration> user = service.getAllUsername();
		List<String> userList = new ArrayList<>();
		for (Registration registration : user) {
				userList.add(registration.getUsername() +" , "+ registration.getEmail());
		}		
		return userList;
	}
	
	@DELETE
	@Path("/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeUser(@PathParam("userId") int userId) {

		service.deleteUser(userId);

	}
} 
 
