
package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long id)throws Exception {
		Optional<Student> students=studentRepository.findById(id);
			if(students.isPresent()) {
				return students.get();
				
			}
			throw new Exception("id not found");
		}

	@Override
	public Student updateStudent(Student student)throws Exception {
       if(student.getStudentId()!=null) {
    	   Optional<Student> studentResult= studentRepository.findById(student.getStudentId());
    	   if(studentResult.isPresent()) {
    		   
    		   if(student.getStudentName()!=null) {
    			   studentResult.get().setStudentName(student.getStudentName());
    		   }
    		   
    		   if(student.getStudentSub()!=null) {
    			   studentResult.get().setStudentSub(student.getStudentSub());
    		   }
    		   

    		   if(student.getRollNo()==0) {
    			   studentResult.get().setRollNo(student.getRollNo());
    		   }
    		   
    		   if(student.getTeacherName()!=null) {
    			   studentResult.get().setTeacherName(student.getTeacherName());
    		   }
    		   
    		   return studentRepository.save(student);
    	   }
       }
	   throw new Exception("data not found");
		
	}

	@Override
	public String deleteStudent(Long id)  {
		Optional<Student> teachervalue=studentRepository.findById(id);
			if(teachervalue.isPresent()) {
				studentRepository.deleteById(id);
			}
			return "date got deleted" +id;
	}

	@Override
	public List <Student> findByNameOfTeacher(String name) {
	 return studentRepository.findByTeacherName(name);
	}
	
	
	
}
	

	
	


