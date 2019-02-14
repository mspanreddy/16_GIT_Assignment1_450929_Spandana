package com.fse.assignment.service;

import java.util.List;

import com.fse.assignment.model.Subject;

public interface SubjectService {

	Subject createSubject(Subject subject);
	Subject findById(long subjectId);
	void deleteSubjectById(long subjectId);
	List<Subject> findAll();
}