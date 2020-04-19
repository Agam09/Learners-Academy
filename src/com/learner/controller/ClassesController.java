package com.learner.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.learner.model.Classes;
import com.learner.service.ClassesService;
import com.learner.service.implementation.ClassesServiceImplementation;

@Path("/classes")
public class ClassesController {
	
	private ClassesService service = new ClassesServiceImplementation();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Classes createClasses(Classes classes) {

		return service.createClasses(classes);
	}

	@GET
	@Path("/{classId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Classes getClassesById(@PathParam("classId") int classId) {

		return service.getClassesById(classId);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Classes> getAllClasses() {

		return service.getAllClasses();
	}

	@PATCH
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Classes updateClasses(Classes classes) {

		return service.updateClasses(classes);
	}

	@DELETE
	@Path("/{classId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeClasses(@PathParam("classId") int classId) {

		service.deleteClasses(classId);

	}

}
