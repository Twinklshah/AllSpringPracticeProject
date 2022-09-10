package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/Student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/saveStudent")
	public Student saveStudent(@RequestBody Student student) {
		 return studentService.saveStudent(student);
	}
	
	@PostMapping("/list-of-Student")
	public List<Student> listofStudent(@RequestBody Student students){
		 return studentService.listOfStudent();
		 
	}
	@GetMapping("/get-student")
	public List<Student> getAllStudent(@RequestBody Student stud){
		return studentService.getAllStudent();
		}
	
	@GetMapping("/getStudentByID")
	public List<Student> getStudentById(@RequestBody Student stud){
		return studentService.getStudentById();
	}

}
