package com.learner.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learner.dao.ClassesDAO;
import com.learner.dao.implementation.SessionUtil;
import com.learner.model.Classes;

public class ClassesDaoImplementation implements ClassesDAO {
	
	private static SessionUtil sessionUtil = SessionUtil.getInstance();
	@Override
	public Classes createClasses(Classes classes) {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(classes);
		transaction.commit();
		session.close();
		return classes;
	}

	@Override
	public Classes getClassesById(int classId) {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Classes classes = (Classes) session.get(Classes.class, classId);
		transaction.commit();
		session.close();
		return classes;
	}

	@Override
	public List<Classes> getAllClasses() {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		List<Classes> classesList = session.createQuery("from com.learner.model.Classes").list();
		transaction.commit();
		session.close();
		return classesList;
	}

	@Override
	public Classes updateClasses(Classes classes) {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(classes);
		transaction.commit();
		session.close();
		return classes;
	}

	@Override
	public void deleteClasses(int classId) {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Classes cla = new Classes();
		cla.setClassId(classId);
		session.delete(cla);
		transaction.commit();
		session.close();
	}

}
