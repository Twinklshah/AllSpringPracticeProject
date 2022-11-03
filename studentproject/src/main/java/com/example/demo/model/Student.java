package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import lombok.Data;
@SQLDelete(sql="update Student set is_active=false where student_id=?")
@Data
@Entity
@Table(name="Student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	private String studentName;
	private String studentSub;
	private int rollNo;
	private String teacherName;
	private Boolean isActive=true;
	

}
