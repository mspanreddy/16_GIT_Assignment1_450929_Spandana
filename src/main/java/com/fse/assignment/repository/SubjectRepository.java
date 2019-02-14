package com.fse.assignment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fse.assignment.model.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long>{

}
