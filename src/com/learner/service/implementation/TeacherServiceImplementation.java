package com.learner.service.implementation;

import java.util.List;

import com.learner.dao.TeacherDAO;
import com.learner.dao.implementation.TeacherDaoImplementation;
import com.learner.model.Teacher;
import com.learner.service.TeacherService;

public class TeacherServiceImplementation implements TeacherService {
	
	private TeacherDAO dao = new TeacherDaoImplementation();

	@Override
	public Teacher createTeacher(Teacher teacher) {

		return dao.createTeacher(teacher);
	}

	@Override
	public Teacher getTeacherById(int teacherId){
		return dao.getTeacherById(teacherId);

	}

	@Override
	public List<Teacher> getAllTeachers() {

		return dao.getAllTeachers();
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {

		return dao.updateTeacher(teacher);
	}

	@Override
	public void deleteTeacher(int teacherId) {

		dao.deleteTeacher(teacherId);

	}

}
