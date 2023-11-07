package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.StudentEntity;

@Component
public interface IStudentService {
	
	public StudentEntity saveStudentToDataBase(StudentEntity studentEntity);

	public List<StudentEntity> getAllStudents();
	
	public StudentEntity getStudentById(int id);
	
	public String deleteStudentById(int id);
	
	public StudentEntity UpdateStudent(StudentEntity studentEntity);
}
