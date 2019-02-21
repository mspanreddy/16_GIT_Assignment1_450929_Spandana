package com.fse.assignment.model;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="BOOK")
public class Book implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="book_id")
	private long bookId;
	
	@Column(name = "title")
	private String title;
	

	@Column(name="price")
	private double price;
	
	@Column(name="volume")
	private Integer volume;
	
	@Column(name="publish_date")
	private LocalDate publishDate;
	
	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="subject_id")
	private Subject subject;
	
	public Book(){}
	
	public Book(String title,double price,Integer volume,LocalDate publishDate, Subject subject){
		this.title=title;
		this.price=price;
		this.volume=volume;
		this.publishDate=publishDate;
		this.subject=subject;
	}
	
	public Book(long bookId,String title,double price,Integer volume,LocalDate publishDate,Subject subject){
		this.bookId=bookId;
		this.title=title;
		this.price=price;
		this.volume=volume;
		this.publishDate=publishDate;
		this.subject=subject;
	}
}