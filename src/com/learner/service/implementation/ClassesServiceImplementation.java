package com.learner.service.implementation;

import java.util.List;

import com.learner.dao.ClassesDAO;
import com.learner.dao.implementation.ClassesDaoImplementation;
import com.learner.model.Classes;
import com.learner.service.ClassesService;

public class ClassesServiceImplementation implements ClassesService {

	private ClassesDAO dao = new ClassesDaoImplementation();

	@Override
	public Classes createClasses(Classes classes) {

		return dao.createClasses(classes);

	}

	@Override
	public Classes getClassesById(int classId){

		return dao.getClassesById(classId);
		
	}

	@Override
	public List<Classes> getAllClasses() {

		return dao.getAllClasses();
	}

	@Override
	public Classes updateClasses(Classes classes) {

		return dao.updateClasses(classes);

	}

	@Override
	public void deleteClasses(int classId) {

		dao.deleteClasses(classId);

	}
}
