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
@Entity
@Table(name="Department_table")
public class Department {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="department_id")
	private Long departmentId;
	
	@Column(name="department_head")
	private String departmentHead;
	
	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="department_contact")
	private Integer departmentContact;
	
	

}
