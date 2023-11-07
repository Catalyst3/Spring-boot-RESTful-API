package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.StudentEntity;
import com.example.demo.service.IStudentService;
//@Controller
public class StudentController {
	@Autowired
	private IStudentService iStudentService;
	@GetMapping("/home")
	public String goToHomePage(Model model)
	{
		System.out.println("Inside HomeController File");
		model.addAttribute("studentList",iStudentService.getAllStudents());
		return "Home";
	}
	@GetMapping("/student")
	public String goToStudetAddPage()
	{
		return "Student";	
	}
	@PostMapping("/add")
	public String addStudent(@ModelAttribute StudentEntity student, Model model )
	{
		iStudentService.saveStudentToDataBase(student);
		model.addAttribute("studentList",iStudentService.getAllStudents());
		return "Home";
	}
}
