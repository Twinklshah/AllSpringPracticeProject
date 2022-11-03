package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {

	public Student saveStudent(Student student);
	public List<Student> getAllStudent();
	public Student getStudentById(Long id)throws Exception;
	public Student updateStudent(Student student)throws Exception;
	public String deleteStudent(Long id);
	public List<Student> findByNameOfTeacher(String name);
	
	
}
