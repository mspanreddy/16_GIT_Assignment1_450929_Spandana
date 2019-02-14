package com.fse.assignment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fse.assignment.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

}
