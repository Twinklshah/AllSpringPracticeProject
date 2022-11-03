package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {
	
//	public Student saveStudent(Student student);
	
	Student saveStudent(Student student);
	public List<Student> getStudent();
//    Student updateStudent(Student student);
	Student getStudentById(Long id)throws Exception;
}
