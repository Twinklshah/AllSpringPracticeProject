package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		 return new ResponseEntity<Student>(studentService.saveStudent(student));
	}
	
	@PostMapping("/saveAllStudent")
	public List<Student> listofStudent(@RequestBody List<Student> student){
		 return studentService.saveAllStudents(student);
		 
	}
	@GetMapping("/get-student")
	public List<Student> getAllStudent(){
		return studentService.getAllStudent();
		}
	
	@GetMapping("/getStudentByID")
	public List<Student> getStudentById(){
		return studentService.getStudentById();
	}

}
