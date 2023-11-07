package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.StudentEntity;
import com.example.demo.service.impl.StudentServiceIMPL;
//@RestController
public class StudentRestController {

	@Autowired
	private StudentServiceIMPL serviceIMPL;
	
	@PostMapping("/add")
	public ResponseEntity<?> addStudent(@RequestBody StudentEntity studentEntity)
	{
		ResponseEntity<?> entity = null;
		
		StudentEntity s = serviceIMPL.saveStudentToDataBase(studentEntity);

		try {

			entity = new ResponseEntity<StudentEntity>(s,HttpStatus.OK);
			
		} catch (Exception e) {
			
			entity = new ResponseEntity<String>("Data Insertion Faild.."+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return entity;
	}
	@GetMapping("/all")
	public ResponseEntity<List<StudentEntity>> getAllStudents()
	{
		ResponseEntity<List<StudentEntity>> e = new ResponseEntity<List<StudentEntity>>(serviceIMPL.getAllStudents(),HttpStatus.OK);
		return e;
	}
	
	@GetMapping("/get/{sid}")
	public ResponseEntity<?> getStudentById(@PathVariable Integer sid)
	{
		ResponseEntity<?> entity = null;
		
		
		try {
		
			entity = new ResponseEntity<StudentEntity>(serviceIMPL.getStudentById(sid),HttpStatus.OK);
			
		} catch (Exception e) {
			
			entity = new ResponseEntity<String>("Record Not Found..",HttpStatus.OK);

		}
		
		return entity;
	}
	
}
