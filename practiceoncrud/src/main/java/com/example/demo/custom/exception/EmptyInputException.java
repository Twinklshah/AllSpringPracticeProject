package com.example.demo.custom.exception;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class EmptyInputException extends RuntimeException{
	
	private static final long serialVersionUID=1L;
	 private String errorCode;
	 private String errorMessage;

	 public static final long getSerialversionuid() {
		 return getSerialversionuid();
	 }
	 
	 public EmptyInputException(String errorCode, String errorMessage) {
		 
	 }
}
