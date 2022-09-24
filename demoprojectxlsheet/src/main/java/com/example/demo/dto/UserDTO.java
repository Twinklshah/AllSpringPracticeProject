package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserDTO {

	private String usersName;
	private String usersAddress;
	private Integer departmentId;
	private Integer mobileNo;

}

