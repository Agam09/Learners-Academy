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

import com.learner.model.Student;
import com.learner.service.StudentService;
import com.learner.service.implementation.StudentServiceImplementation;

@Path("/student")
public class StudentController {
	

	private StudentService service = new StudentServiceImplementation();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student createStudent(Student student) {

		return service.createStudent(student);
	}

	@GET
	@Path("/{studentId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentById(@PathParam("studentId") int studentId) {

		return service.getStudentById(studentId);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudents() {

		return service.getAllStudents();
	}

	@PATCH
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student updateStudent(Student student) {

		return service.updateStudent(student);
	}

	@DELETE
	@Path("/{studentId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeStudent(@PathParam("studentId") int studentId) {

		service.deleteStudent(studentId);

	}


}
