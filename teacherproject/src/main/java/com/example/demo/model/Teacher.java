package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.NoArgsConstructor;
@SQLDelete(sql="update teacher set is_active=false where teacher_id=?")
@Data
@NoArgsConstructor
@Entity
@Table(name="Teacher")
@EntityListeners(AuditingEntityListener.class)
public class Teacher {
	
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long teacherId;
   private String teacherName;
   private String teacherSub;
   private Boolean isActive= true;
  
   @CreatedBy
   private String createdBy;
   
   @CreatedDate
   private Date createdOn;
  
   @LastModifiedBy
   private String lastModifiedBy;
   
   @LastModifiedDate 
   private Date lastModifiedOn;
   
		   
		   
		   
}
