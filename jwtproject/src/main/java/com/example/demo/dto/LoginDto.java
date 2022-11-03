package com.example.demo.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;


@Data
public class LoginDto {
	
	private String token;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;

}
