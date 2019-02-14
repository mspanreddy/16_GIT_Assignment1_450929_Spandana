package com.fse.assignment.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fse.assignment.model.Subject;
import com.fse.assignment.service.SubjectServiceImpl;
@Controller
public class SubjectController {
	@Autowired
	private SubjectServiceImpl subjectService;


	@RequestMapping(value="/subject/",method = RequestMethod.POST)
	public String addSubject(ModelMap model,@ModelAttribute("subject")Subject newSubject) {
		subjectService.createSubject(newSubject);
		List<Subject> subjects = subjectService.findAll();
		model.addAttribute("subjects", subjects);
		model.addAttribute("msg", "Subject Added successfully!");
		return "subjects";
	}

	@RequestMapping(value="/delsub/{subjectId}",method = RequestMethod.GET)
	public String deleteSubject(ModelMap model,@PathVariable int subjectId) {
		subjectService.deleteSubjectById(subjectId);
		List<Subject> subjects = subjectService.findAll();
		model.addAttribute("subjects", subjects);
		model.addAttribute("msg", "Subject Added successfully!");
		return "subjects";
		
	}

	@GetMapping("/subject/{subjectId}")
	public String getSubjectById(ModelMap model,@PathVariable long subjectId) {
		Subject subject = subjectService.findById(subjectId);
		model.addAttribute("subject", subject);
		model.addAttribute("msg", "Subject Details");
		return "subject";
	}
	
	@RequestMapping("/subjects/")
	public String  getSubjects(ModelMap model) throws IOException {
		List<Subject> subjects = subjectService.findAll();
		model.addAttribute("subjects", subjects);
		model.addAttribute("msg", "All Subject");
		return "subjects";
	}

}
