package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class StudentServiceImpl implements StudentService{
   
	@Autowired
	StudentRepository studentRepository;
	
	
    
    public Student saveStudent(Student student) {
    	log.info("student name created");
    	return studentRepository.save(student);
    }
    
    public List<Student> saveAllStudents(List<Student> students){
    	return studentRepository.saveAll(students);
    }

    public List<Student> getAllStudent(){
    	return studentRepository.findAll();
    }
    
    public Optional<Student> getStudentById(Long Id){
    	return studentRepository.findById(Id);
    }


	@Override
	public List<Student> getStudentById() {
		// TODO Auto-generated method stub
		return null;
	}
}
