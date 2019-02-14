package com.fse.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fse.assignment.model.Subject;
import com.fse.assignment.repository.SubjectRepository;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService{
	  @Autowired
	    SubjectRepository subjectRepo;
	@Override
	public Subject createSubject(Subject subject) {
		return subjectRepo.save(subject);
	}

	@Override
	public Subject findById(long subjectId) {
		return subjectRepo.findById(subjectId).get();
	}

	@Override
	public void deleteSubjectById(long subjectId) {
		subjectRepo.deleteById(subjectId);	
	}
	@Override
	public List<Subject> findAll() {
		return (List<Subject>) subjectRepo.findAll();
	}

}
