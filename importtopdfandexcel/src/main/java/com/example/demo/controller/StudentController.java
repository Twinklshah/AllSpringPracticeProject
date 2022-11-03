package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	private PdfGenaratorUtil pdfGenaratorUtil;
	
	@PostMapping("/save" )
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@GetMapping("/getAll")
	public List<Student> getAllStudent(){
		return studentService.getStudent();
	}

	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable Long id) throws Exception {
		return studentService.getStudentById(id);
	}
}
