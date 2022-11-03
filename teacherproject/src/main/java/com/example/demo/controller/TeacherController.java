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

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Teacher;
import com.example.demo.service.TeacherService;

@RestController
@RequestMapping("/Teacher")
public class TeacherController {
	@Autowired
	TeacherService teacherService;
	
	@PostMapping("/addTeacher")
	public Teacher addTeacher(@RequestBody Teacher teacher) {
		return teacherService.saveTeacher(teacher);
	}
	
	@GetMapping("/allTeacher")
	public List<Teacher> getAllTeacher(){
		return teacherService.getAllTeacher();
	}
	@GetMapping("/{id}")
	public Teacher getTeacherById(@PathVariable Long id) throws Exception {
		return teacherService.findTeacherById(id);
	}
	 
	@GetMapping("getTeacher/{name}")
	
	public StudentDto[] findByNameOfTeacher(@PathVariable String name) throws Exception {
		return teacherService.getStudentByTeacherName(name);
		
	}
    @PutMapping("/update")
	public Teacher updateTeacher(@RequestBody  Teacher teacher) throws Exception {
		return teacherService.updateTeacher(teacher);
	}
    @DeleteMapping("Delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
    	return teacherService.deleteTeacher(id);
    	
    }
}
