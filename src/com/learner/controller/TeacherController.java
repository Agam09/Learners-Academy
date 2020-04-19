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

import com.learner.model.Teacher;
import com.learner.service.TeacherService;
import com.learner.service.implementation.TeacherServiceImplementation;

@Path("/teacher")
public class TeacherController {

	private TeacherService service = new TeacherServiceImplementation();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Teacher createTeacher(Teacher teacher) {

		return service.createTeacher(teacher);
	}

	@GET
	@Path("/{teacherId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Teacher getTeacherById(@PathParam("teacherId") int teacherId) {
		
		 return service.getTeacherById(teacherId);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Teacher> getAllTeachers() {

		return service.getAllTeachers();
	}

	@PATCH
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Teacher updateTeacher(Teacher teacher) {

		return service.updateTeacher(teacher);
	}

	@DELETE
	@Path("/{teacherId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeTeacher(@PathParam("teacherId") int teacherId) {

		service.deleteTeacher(teacherId);

	}
}
