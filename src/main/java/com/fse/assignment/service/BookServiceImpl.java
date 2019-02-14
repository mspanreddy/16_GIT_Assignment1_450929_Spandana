package com.fse.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fse.assignment.model.Book;
import com.fse.assignment.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	  @Autowired
	    BookRepository bookRepo;

	@Override
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	@Override
	public Book findById(long id) {
		return bookRepo.findById(id).get();
	}
	@Override
	public void deleteBookById(long id) {
		bookRepo.deleteById(id);
	}
	@Override
	public List<Book> findAll() {
		return (List<Book>) bookRepo.findAll();
	}
}
