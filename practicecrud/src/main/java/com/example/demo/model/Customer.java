package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
@Entity
@Table(name="CustomeData")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="customerID")
	private Long customerId;
	
	@Column(name="CustomerName")
	private String customerName;
	
	@Column(name="CustomerAdd")
	private String customerAdd;

}
