package com.gvt.application.usermanagement.entity.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_PROFILE")
public class UserProfile
	{
		
		@Id
		@Column(name = "ID", length = 30)
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long	id;
		
		@Column(name = "FIRST_NAME", length = 100, nullable = false)
		private String	firstname;
		
		@Column(name = "LAST_NAME", length = 100, nullable = false)
		private String	lastName;
		
		@Column(name = "USER_ID", length = 100, nullable = false)
		private String	userId;
		
	}
