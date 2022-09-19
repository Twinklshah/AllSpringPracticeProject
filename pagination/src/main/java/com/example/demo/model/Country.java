package com.example.demo.model;

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
@Table(name="Countries")

public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long countryId;
	private String countryName;
	private String countryPopulation;
	
	
	

}
