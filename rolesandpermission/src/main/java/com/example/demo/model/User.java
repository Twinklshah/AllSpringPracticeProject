package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="userTable")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "name cannot be null")
	@NotBlank(message = "name cannot be blank")
	private String firstName;
	
	@NotNull(message ="lastName should not be null")
	@NotBlank(message = "lastName should not be blank")
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="dd-mm-yyyy")
	@JsonFormat(pattern = "dd-mm-yyyy",shape = Shape.STRING)
	@NotBlank(message = "dob should not be blank")
	@NotNull(message = "dob shouldl not be null")
	private String dob;
	
	@NotNull(message = "email cannot be null")
	@NotBlank(message = "email cannot be blank")
	private String email;
	
	@NotNull(message = "password cannot be null")
	@NotBlank(message = "password cannot be blank")
	private String password;
	
	
	private List<UserRole> userRole;
	

}
