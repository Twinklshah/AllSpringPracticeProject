package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.sql.Update;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@SQLDelete(sql ="update Customer set is_active=false where customer_id=?")
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;
	private String customerName;
	private String customerOccupation;
	private Boolean isActive=true;


}
