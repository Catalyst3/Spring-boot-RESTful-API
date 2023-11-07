package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentEntity;
import com.example.demo.entity.repository.Studentrepository;
import com.example.demo.service.IStudentService;
@Service
public class StudentServiceIMPL implements IStudentService {
	@Autowired
	private Studentrepository studentrepository;
	
	@Override
	public StudentEntity saveStudentToDataBase(StudentEntity studentEntity) {
		return studentrepository.save(studentEntity);	
	}
	@Override
	public List<StudentEntity> getAllStudents() {
		List<StudentEntity> student = studentrepository.findAll();
		System.out.println(student.toString());
		return student;
	}
	
	@Override
	public StudentEntity getStudentById(int id) {

		return studentrepository.findById(id).get();
	}
	@Override
	public String deleteStudentById(int id) {
		String error;
		try {
			studentrepository.deleteById(id);
			return "sucess";
		} catch (Exception e) {
			error = e.getMessage();
		}
		return error;
	}
	@Override
	public StudentEntity UpdateStudent(StudentEntity studentEntity) {
		
		return studentrepository.save(studentEntity);
	}
	
}
