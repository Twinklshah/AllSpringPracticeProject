package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

//	Optional<Teacher> findByName(String name);


	List<Teacher> findByTeacherName(String teacherName);
	

}
