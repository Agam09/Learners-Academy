package com.learner.service.implementation;

import java.util.List;

import com.learner.dao.StudentDAO;
import com.learner.dao.implementation.StudentDaoImplementation;
import com.learner.model.Student;
import com.learner.service.StudentService;

public class StudentServiceImplementation implements StudentService {
	
	private StudentDAO dao = new StudentDaoImplementation();

	@Override
	public Student createStudent(Student student) {

		return dao.createStudent(student);
	}

	@Override
	public Student getStudentById(int studentId) {

		return	 dao.getStudentById(studentId);
		
	}

	@Override
	public List<Student> getAllStudents() {

		return dao.getAllStudents();
	}

	@Override
	public Student updateStudent(Student student) {

		return dao.updateStudent(student);
	}

	@Override
	public void deleteStudent(int studentId) {

		dao.deleteStudent(studentId);

	}

}
