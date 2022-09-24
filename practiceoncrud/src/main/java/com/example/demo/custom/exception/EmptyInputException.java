package com.example.demo.custom.exception;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmptyInputException extends RuntimeException implements Serializable{
	
 
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	 private String errorMessage;


	 

	 
}
