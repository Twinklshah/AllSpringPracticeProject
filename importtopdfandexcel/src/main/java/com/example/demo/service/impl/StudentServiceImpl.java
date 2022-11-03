package com.example.demo.service.impl;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getStudent() {
		return studentRepository.findAll();
		
	}

	@Override
	public Student getStudentById(Long id) throws Exception {
		Optional<Student> studentResponse=studentRepository.findById(id);
		if(studentResponse.isPresent()) {
			return studentResponse.get();
		}
		throw new Exception("id not found");
		
	}
	Map<String,Object> studentMap = new HashMap<>();
	


//	studentMap.put("ID",student.getId());
//	studentMap.("ID")
//
//	studentMap.put("firstName"student.getFirstName());
//
//	studentMap.put("lastName",student.getLastName());
//
//	studentMap.put("class",student.getClass());
//
//	Resource resource = null;
//
//	try {
//
//	String property = "java.io.tmpdir";
//
//	String tempDir = System.getProperty(property);
//
//	String fileNameUrl = pdfGenaratorUtil.createPdf("Student", studentMap);
//
//	Path path = Paths.get(tempDir+"/" + fileNameUrl);
//
//	resource = new UrlResource(path.toUri());
//
//	} catch (Exception e) {
//
//	e.printStackTrace();
//
//	}
//
//	return ResponseEntity.ok()
//
//	.contentType(MediaType.parseMediaType(MediaType.APPLICATION_PDF_VALUE))
//
//	.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//
//	.body(resource);
//
//	}
//
//	}

//	@Override
//	public Student updateStudent(Student student) {
//	 
//	}






}
