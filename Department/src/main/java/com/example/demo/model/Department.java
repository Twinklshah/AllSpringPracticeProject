package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@SQLDelete(sql = "update Department_table set is_active=false where department_id=?")
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
	
	
	private Boolean isActive = true;
	
	private Boolean isDeleted = false;  // softdelete 
	
	//auditlog
	@LastModifiedBy
	private String updatedBy;
	
	@CreatedBy
	private String createdBy;
	
	@CreatedDate
	private Date createdAt;
	
	@LastModifiedDate
	private Date updatedAt;
	

}
