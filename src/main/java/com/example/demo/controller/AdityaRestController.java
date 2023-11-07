package com.example.demo.controller;

import java.util.List;

import javax.persistence.Entity;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.StudentEntity;
import com.example.demo.service.IStudentService;
import com.example.demo.service.impl.StudentServiceIMPL;

@RestController
public class AdityaRestController {
	@Autowired
	private IStudentService impl;

	// To add data to dataBase
	@PostMapping("/add")
	public ResponseEntity<?> addStudent(@RequestBody StudentEntity studentEntity) {
		System.out.println("Inside Add");
		ResponseEntity<?> entity = null;
		StudentEntity s = impl.saveStudentToDataBase(studentEntity);
		try {
			entity = new ResponseEntity<StudentEntity>(s, HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>("Data Insertion is Failed" + e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return entity;
	}

	// To get Data From DataBase
	@GetMapping("/getData")
	public ResponseEntity<?> getStudentDetails() {
		ResponseEntity<?> entity = null;

		try {
			entity = new ResponseEntity<List<StudentEntity>>(impl.getAllStudents(), HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>("Don't have any data" + e, HttpStatus.NOT_FOUND);
		}
		return entity;
	}

	// to get Record By Id
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getStudentByID(@PathVariable Integer id) {
		ResponseEntity<?> entity = null;

		try {
			entity = new ResponseEntity<StudentEntity>(impl.getStudentById(id), HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>("Not Found" + e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return entity;

	}
	//To delete Record
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deteteStudent(@PathVariable Integer id)
	{
		System.out.println("================delete By ID====================");
		System.out.println(id);
		ResponseEntity<String> entity = null;
		;
		try {
			entity = new ResponseEntity<String> (impl.deleteStudentById(id),HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String> (impl.deleteStudentById(id),HttpStatus.NOT_FOUND);
		}
		return entity;
	}
	
	// To Update record
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody StudentEntity studentEntity)
	{
		ResponseEntity<?> entity = null;
		try {
			entity=new ResponseEntity<StudentEntity> (impl.UpdateStudent(studentEntity),HttpStatus.OK);
		} catch (Exception e) {
			entity=new ResponseEntity<String> ("Failed to Update"+e,HttpStatus.BAD_REQUEST);
		}
		return entity;
		
	}
}
