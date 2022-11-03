package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CustomerDTO {

	private Long customerId;
	private String customerEmail;
	private String firstName;
//	private String lastName;
	
//	@JsonProperty(access = Access.WRITE_ONLY) //its only accept the data and save into the database and doesn't send back in a response.
	
	@JsonIgnore
	@Getter(onMethod = @__( @JsonIgnore )) //its another way too 
	    @Setter
	private String password;
 
}
