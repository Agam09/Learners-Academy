package com.learner.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learner.dao.SubjectDAO;
import com.learner.model.Subject;

public class SubjectDaoImplementation implements SubjectDAO{
	
	private static SessionUtil sessionUtil = SessionUtil.getInstance();

	@Override
	public Subject createSubject(Subject subject) {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(subject);
		transaction.commit();
		session.close();
		return subject;
	}

	@Override
	public Subject getSubjectById(int subjectId) {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Subject subject = (Subject) session.get(Subject.class, subjectId);
		transaction.commit();
		session.close();
		return subject;
	}

	@Override
	public List<Subject> getAllSubject() {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		List<Subject> subjectList = session.createQuery("from com.learner.model.Subject").list();
		transaction.commit();
		session.close();
		return subjectList;
	}

	@Override
	public Subject updateSubject(Subject subject) {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(subject);
		transaction.commit();
		session.close();
		return subject;
	}

	@Override
	public void deleteSubject(int subjectId) {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Subject sub = new Subject();
		sub.setSubjectId(subjectId);
		session.delete(sub);
		transaction.commit();
		session.close();

	}

}
