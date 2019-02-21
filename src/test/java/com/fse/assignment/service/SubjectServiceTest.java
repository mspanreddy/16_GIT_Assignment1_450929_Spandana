package com.fse.assignment.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fse.assignment.model.Subject;
import com.fse.assignment.repository.SubjectRepository;

public class SubjectServiceTest {
	@Mock
	private  SubjectRepository subjectRepo;
	
	@InjectMocks
	private  SubjectServiceImpl subjectService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testfindAll(){
		List<Subject> subjects = new ArrayList<Subject>();
		subjects.add(new Subject(1, "Subject Title 1", 20));
		subjects.add(new Subject(2, "Subject Title 2", 200));
		subjects.add(new Subject(3, "Subject Title 3", 50));
		when(subjectRepo.findAll()).thenReturn(subjects);
		List<Subject> subjectsList = subjectService.findAll();
		assertEquals(3, subjectsList.size());
	}
	@Test
	public void testCreatSubject() {
		Subject subject = new Subject(1, "Subject Title 1", 20);
		when(subjectRepo.save(subject)).thenReturn(subject);
		Subject newSubject = subjectService.createSubject(subject);
		assertEquals(1, newSubject.getSubjectId());
		assertEquals("Subject Title 1", newSubject.getSubtitle());
	}
	@Test
	public void testDeleteSubjectById() {
		Subject subject = new Subject(1, "Subject Title 1", 20);
        Optional<Subject> sub = Optional.of(subject);
         when(subjectRepo.findById(1L)).thenReturn(sub);
         subjectService.deleteSubjectById(subject.getSubjectId());
        verify(subjectRepo, times(1)).deleteById(subject.getSubjectId());
	}
	@Test
	public void testFindById() {
		Subject subject = new Subject(1, "Subject Title 1", 20);
		when(subjectRepo.findById((long) 1)).thenReturn(Optional.of(subject));
		Subject sub = subjectService.findById(1);
		assertEquals(1, sub.getSubjectId());
		assertEquals("Subject Title 1", sub.getSubtitle());
	}
}
