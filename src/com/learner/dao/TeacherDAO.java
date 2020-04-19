package com.learner.dao;

import java.util.List;

import com.learner.model.Teacher;

public interface TeacherDAO {
	
	public Teacher createTeacher(Teacher teacher);

	public Teacher getTeacherById(int teacherId);

	public List<Teacher> getAllTeachers();

	public Teacher updateTeacher(Teacher teacher);

	public void deleteTeacher(int teacherId);

}
