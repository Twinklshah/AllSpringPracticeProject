package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;

import com.example.demo.model.Student;

@Transactional
public interface StudentService {
	
HttpStatus saveStudent(Student student);

List<Student> saveAllStudents(List<Student> students);

List<Student> getAllStudent();

List<Student> getStudentById();

	
	

}
