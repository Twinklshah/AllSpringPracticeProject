package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@SQLDelete(sql="update ClientTable set is_active=false where client_id=?")
@NoArgsConstructor
@Entity
@Table(name="users")
@EntityListeners(AuditingEntityListener.class)
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ClientId;
	private String ClientName;
	private String ClientAdd;
	private Integer ClientContact;
	private Boolean isActive=true;



	@NotBlank
	@Column(name="username", unique = true)
	private String username;

	@NotBlank
	private String password;

	@CreatedBy
	private String createdBy;

	@CreatedDate
	private Date createdOn;

	@LastModifiedBy
	private String lastModifiedBy;

	@LastModifiedDate 
	private Date lastModifiedOn;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "ClientId", nullable = false)
	private List<ClientRole> role;
}
