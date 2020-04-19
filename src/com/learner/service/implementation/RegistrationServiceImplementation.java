package com.learner.service.implementation;


import java.util.List;

import com.learner.dao.RegistrationDAO;
import com.learner.dao.implementation.RegistrationDaoImplementation;
import com.learner.model.Registration;
import com.learner.service.RegistrationService;

public class RegistrationServiceImplementation implements RegistrationService {
	
	private RegistrationDAO dao = new RegistrationDaoImplementation();

	@Override
	public Registration createRegistration(Registration registration) {
		
		return dao.createRegistration(registration);
	}

	@Override
	public Registration getUsernameById(int userId) {
		
		return dao.getUsernameById(userId);
	}

	@Override
	public List<Registration> getAllUsername() {
		
		return dao.getAllUsername();
	}

	@Override
	public void deleteUser(int userId) {
		
		 dao.deleteUser(userId);
		
	}

} 