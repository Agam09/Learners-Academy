package com.learner.service.implementation;

import java.util.List;

import com.learner.dao.SubjectDAO;
import com.learner.dao.implementation.SubjectDaoImplementation;
import com.learner.model.Subject;
import com.learner.service.SubjectService;

public class SubjectServiceImplementation implements SubjectService {
	
	private SubjectDAO dao = new SubjectDaoImplementation();

	@Override
	public Subject createSubject(Subject subject) {

		return dao.createSubject(subject);
	}

	@Override
	public Subject getSubjectById(int subjectId) {
		return dao.getSubjectById(subjectId);
 
	}

	@Override
	public List<Subject> getAllSubject() {

		return dao.getAllSubject();
	}

	@Override
	public Subject updateSubject(Subject subject) {

		return dao.updateSubject(subject);
	}

	@Override
	public void deleteSubject(int subjectId) {

		dao.deleteSubject(subjectId);

	}

}
