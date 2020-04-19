package com.learner.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learner.dao.StudentDAO;
import com.learner.model.Student;

public class StudentDaoImplementation implements StudentDAO {
	
	private static SessionUtil sessionUtil = SessionUtil.getInstance();
	
	@Override
	public Student createStudent(Student student) {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
		session.close();
		return student;
	}

	@Override
	public Student getStudentById(int studentId) {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Student student = (Student) session.get(Student.class, studentId);
		transaction.commit();
		session.close();
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		List<Student> studentList = session.createQuery("from com.learner.model.Student").list();
		transaction.commit();
		session.close();
		return studentList;
	}

	@Override
	public Student updateStudent(Student student) {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(student);
		transaction.commit();
		session.close();
		return student;
	}

	@Override
	public void deleteStudent(int studentId) {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Student stu = new Student();
		stu.setStudentId(studentId);
		session.delete(stu);
		transaction.commit();
		session.close();

	}
}