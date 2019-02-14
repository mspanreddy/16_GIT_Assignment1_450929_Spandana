package com.fse.assignment.service;

import java.util.List;

import com.fse.assignment.model.Book;

public interface BookService {

	public Book createBook(Book book);
	public void deleteBookById(long bookId);
	public Book findById(long bookId);
	List<Book> findAll();
}

