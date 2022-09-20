package com.example.demo.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.custom.exception.EmptyInputException;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NoSuchElementException.class)
		public ResponseEntity<String> handleNosuchException(NoSuchElementException elementException){
		return new ResponseEntity<String>("NO such value present in DB, please change your request",HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<Object>("please change your http method type",HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> emptyExceptionhandle(EmptyInputException emptyInputException){
		return new ResponseEntity<String>("inputs fields are empty please look into it",HttpStatus.BAD_REQUEST);
		
	}
	

}
