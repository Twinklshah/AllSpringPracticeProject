package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Teacher;

public interface TeacherService {
	public Teacher saveTeacher(Teacher teacher) ;
	public List<Teacher> getAllTeacher();
	public StudentDto[] getStudentByTeacherName(String name)throws Exception;
	public Teacher findTeacherById(Long id)throws Exception;
	public Teacher updateTeacher(Teacher teacher) throws Exception;
	public String deleteTeacher(Long id);
		
	

}
