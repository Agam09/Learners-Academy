package com.learner.dao.implementation;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.learner.dao.RegistrationDAO;
import com.learner.model.Registration;

public class RegistrationDaoImplementation implements RegistrationDAO {
	
	private static SessionUtil sessionUtil = SessionUtil.getInstance();

	@Override
	public Registration createRegistration(Registration registration) {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(registration);
			transaction.commit();
		} catch (ConstraintViolationException e) {
			return null;
		}
		session.close();
		return registration;
	}

	@Override
	public Registration getUsernameById(int userId) {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Registration registration = (Registration) session.get(Registration.class, userId);
		transaction.commit();
		session.close();
		return registration;
	}

	@Override
	public List<Registration> getAllUsername() {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		List<Registration> userList = session.createQuery("from com.learner.model.Registration").list();
		transaction.commit();
		session.close();
		return userList;
	}

	@Override
	public void deleteUser(int userId) {
		Session session = sessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Registration registration = new Registration();
		registration.setUserId(userId);
		session.delete(registration);
		transaction.commit();
		session.close();
		
	}
	
	

} 