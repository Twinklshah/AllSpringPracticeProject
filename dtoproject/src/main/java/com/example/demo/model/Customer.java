package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="Customer")

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long customerId;
	private String customerEmail;
	private String firstName;
	private String lastName;
	private String password;
 
	
//	@ManyToOne(fetch = FetchType.EAGER,optional = false)
//	@JoinColumn(name="locationId")
//	private Location location;
}
