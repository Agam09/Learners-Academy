package com.learner.dao;


import java.util.List;

import com.learner.model.Registration;

public interface RegistrationDAO {

	public Registration createRegistration(Registration registration);
	public Registration getUsernameById(int userId);
	public List<Registration> getAllUsername();
	public void deleteUser(int userId);
} 
 
