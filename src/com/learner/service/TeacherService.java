package com.learner.service;

import java.util.List;

import com.learner.model.Teacher;

public interface TeacherService {
	
	public Teacher createTeacher(Teacher teacher);

	public Teacher getTeacherById(int teacherId);

	public List<Teacher> getAllTeachers();

	public Teacher updateTeacher(Teacher teacher);

	public void deleteTeacher(int teacherId);

}
