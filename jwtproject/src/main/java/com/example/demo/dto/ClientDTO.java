package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.example.demo.model.ClientRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDTO {  //save user for regristration 
	
	private Long ClientId;  // starting letter should always be small while usin
	private String ClientName;
	private String ClientAdd;
	private Integer ClientContact;
	private Boolean isActive; 
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	private String createdBy;
	private Date createdOn;
	private String lastModifiedBy;
	private Date lastModifiedOn;
	private List<ClientRoleDto> role;
}


