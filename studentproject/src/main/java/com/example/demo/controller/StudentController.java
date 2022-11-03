package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
    
	@GetMapping("/allStudennt")
	public List<Student> getAllStudent(){
		return studentService.getAllStudent();
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable Long id) throws Exception {
		return studentService.getStudentById(id);
	}
	
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) throws Exception {
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		return studentService.deleteStudent(id);
	}
	
	@GetMapping("/getStudent/{name}")
	public List<Student> getStudentByTeacherName(@PathVariable String name) {
		return studentService.findByNameOfTeacher(name);
	}
}
