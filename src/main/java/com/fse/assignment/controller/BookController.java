package com.fse.assignment.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fse.assignment.model.Book;
import com.fse.assignment.service.BookServiceImpl;
import com.fse.assignment.service.SubjectServiceImpl;
@Controller
public class BookController {

	@Autowired
	private BookServiceImpl bookService;
	@Autowired
	private SubjectServiceImpl subjectService;


	@RequestMapping(value="/book/",method = RequestMethod.POST)
	public String addBook(ModelMap model,@ModelAttribute("book")Book newBook) {
		newBook.setPublishDate(LocalDate.now());
		newBook.setSubject(subjectService.findById(5));
		bookService.createBook(newBook);
		List<Book> books = bookService.findAll();
		model.addAttribute("books", books);
		model.addAttribute("msg", "Book Added successfully!");
		return "books";
	}

	@RequestMapping(value="/delbook/{bookId}",method = RequestMethod.GET)
	public String deleteBook(ModelMap model,@PathVariable int bookId) {
		Book b = bookService.findById(bookId);
		bookService.deleteBookById(bookId);
		List<Book> books = bookService.findAll();
		model.addAttribute("books", books);
		model.addAttribute("msg", "Book Added successfully!");
		return "books";
	}

	@RequestMapping("/book/{bookId}")
	public  String  getBookById(ModelMap model,@PathVariable long bookId) {
		Book book = bookService.findById(bookId);
		model.addAttribute("book", book);
		model.addAttribute("msg", "Book Details");
		return "book";
	}
	@RequestMapping("/books/")
	public String  getBooks(ModelMap model) {
		List<Book> books = bookService.findAll();
		model.addAttribute("books", books);
		model.addAttribute("msg", "All Books");
		return "books";
	}

}
