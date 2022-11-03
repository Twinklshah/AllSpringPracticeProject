package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.TeacherService;
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService{
   
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	RestTemplate restTemplate;   
	
	@Override
	public Teacher saveTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
		
	}
	@Override
	public List<Teacher> getAllTeacher() {
		return teacherRepository.findAll();
		
	}
	@Override
	public Teacher updateTeacher(Teacher teacher) throws Exception{
		if(teacher.getTeacherId()!=null) {
			Optional<Teacher> teachers=teacherRepository.findById(teacher.getTeacherId());
			if(teachers.isPresent()) {
				
				if(teacher.getTeacherName()!=null) {
					teachers.get().setTeacherName(teacher.getTeacherName());
				}
				
				if(teacher.getTeacherSub()!=null) {
					teachers.get().setTeacherSub(teacher.getTeacherSub());
				}
				return teacherRepository.save(teacher);
			}
	
		}
		throw new Exception("please enter your id");
	}
	
	@Override
	public String deleteTeacher(Long id){
		Optional<Teacher> teachervalue=teacherRepository.findById(id);
		if(teachervalue.isPresent()) {
			teacherRepository.deleteById(id);
		}
		return "date got deleted" +id;
	}
	@Override
	public Teacher findTeacherById(Long id) throws Exception {
		Optional<Teacher> teacherResponse=teacherRepository.findById(id);
		if(teacherResponse.isPresent()) {
			return teacherResponse.get();			
		}
		throw new Exception("id didn't found");
	}
	@Override
	
	public StudentDto[] getStudentByTeacherName(String name) throws Exception {
		
	List<Teacher> TeacherResponse= teacherRepository.findByTeacherName(name);
	
			if(TeacherResponse !=null) {
				StudentDto[] dto =  restTemplate.getForObject("http://localhost:8080/Student/getStudent/" +name, StudentDto[].class);
			    return dto;
			}
		   throw new Exception("id not found");
		}
	
	}
	





