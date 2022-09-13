package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name="Student_data")
@Entity
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="Student_id")
	private Long studentId;
	
	@Column(name="Student_firstName")
	private String studentFirstName;
	
	@Column(name="Student_lastName")
	private String studentLastName;
	
	@Column(name="Student_RollNo")
	private Integer studentRollNo;
	
	
	

}
