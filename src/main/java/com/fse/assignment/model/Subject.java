package com.fse.assignment.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECT")
public class Subject implements Serializable{

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject_id")
	private long subjectId;
	

	@Column(name = "sub_title")
	private String subtitle;
	

	@Column(name = "duration_in_hours")
	private int durationInHours;

	@OneToMany(mappedBy = "subject")
	private Set<Book> book;

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public int getDurationInHours() {
		return durationInHours;
	}

	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

	public Set<Book> getBook() {
		return book;
	}

	public void setBook(Set<Book> book) {
		this.book = book;
	}
	
	public Subject(long subjectId, String subtitle, int durationInHours) {
		super();
		this.subjectId = subjectId;
		this.subtitle = subtitle;
		this.durationInHours = durationInHours;
	}

	public Subject() {
	}
	
}
