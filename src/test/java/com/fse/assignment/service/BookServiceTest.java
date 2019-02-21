package com.fse.assignment.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.fse.assignment.model.Book;
import com.fse.assignment.model.Subject;
import com.fse.assignment.repository.BookRepository;

public class BookServiceTest {
	@Mock
	private  BookRepository bookRepo;
	
	@InjectMocks
	private  BookServiceImpl bookService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testfindAll(){
		List<Book> books = new ArrayList<Book>();
		books.add(new Book(1, "Book Title 1", 100.00, 100, LocalDate.now(),new Subject()));
		books.add(new Book(2, "Book Title 2", 200.00, 100, LocalDate.now(),new Subject()));
		books.add(new Book(3, "Book Title 3", 300.00, 100, LocalDate.now(),new Subject()));
		when(bookRepo.findAll()).thenReturn(books);
		List<Book> booksList = bookService.findAll();
		assertEquals(3, booksList.size());
	}
	@Test
	public void testCreateBook() {
		Book book = new Book(1, "Book Title 1", 100.00, 100, LocalDate.now(),new Subject());
		when(bookRepo.save(book)).thenReturn(book);
		Book newBook = bookService.createBook(book);
		assertEquals(1, newBook.getBookId());
		assertEquals("Book Title 1", newBook.getTitle());
	}
	@Test
	public void testDeleteBookById() {
        Book book = new Book(1, "Book Title 1", 100.00, 100, LocalDate.now(),new Subject());
        Optional<Book> b = Optional.of(book);
         when(bookRepo.findById(1L)).thenReturn(b);
         bookService.deleteBookById(book.getBookId());
        verify(bookRepo, times(1)).deleteById(book.getBookId());
	}
	@Test
	public void testFindById() {
		Book book =  new Book(1, "Book Title 1", 100.00, 100, LocalDate.now(),new Subject());
		when(bookRepo.findById((long) 1)).thenReturn(Optional.of(book));
		Book b = bookService.findById(1);
		assertEquals(1, b.getBookId());
		assertEquals("Book Title 1", b.getTitle());
	}
}
