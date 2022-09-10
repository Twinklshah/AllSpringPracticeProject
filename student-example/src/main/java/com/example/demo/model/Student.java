package com.example.demo.model;

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
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="Student_id")
	private Long studentId;
	
	@Column(name="Student_firstName")
	private String StudentFirstName;
	
	@Column(name="Student_lastName")
	private String StudentLastName;
	
	@Column(name="Student_RollNo")
	private Integer StudentRollNo;
	
	
	

}
