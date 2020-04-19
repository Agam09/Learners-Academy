package com.learner.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learner.dao.TeacherDAO;
import com.learner.model.Teacher;

public class TeacherDaoImplementation implements TeacherDAO {
	
	private static SessionUtil sessionUtil = SessionUtil.getInstance();
	
	@Override
	public Teacher createTeacher(Teacher teacher) {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(teacher);
		transaction.commit();
		session.close();
		return teacher;
	}

	@Override
	public Teacher getTeacherById(int teacherId) {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Teacher teacher = (Teacher) session.get(Teacher.class, teacherId);
		transaction.commit();
		session.close();
		return teacher;
	}

	@Override
	public List<Teacher> getAllTeachers() {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		List<Teacher> teacherList = session.createQuery("from com.learner.model.Teacher").list();
		transaction.commit();
		session.close();
		return teacherList;
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(teacher);
		transaction.commit();
		session.close();
		return teacher;
	}

	@Override
	public void deleteTeacher(int teacherId) {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Teacher tea = new Teacher();
		tea.setTeacherId(teacherId);
		session.delete(tea);
		transaction.commit();
		session.close();

	}

}
