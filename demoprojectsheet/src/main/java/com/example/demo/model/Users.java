package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@SQLDelete(sql="update users_table set is_active=false where users_id=?")
@NoArgsConstructor
@Entity
@Table(name="usersTable")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usersId;
	private String usersName;
	private String usersAddress;
	private Integer departmentId;
	private Integer mobileNo;
    private Boolean isActive=true;
}
