package com.gvt.application.usermanagement.entity.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.gvt.application.usermanagement.entity.constants.UserStatus;

@Entity
@Table(name = "USER_LOGIN_METADATA")
public class UserLoginMetaData
	{
		@Id
		@Column(name = "ID", length = 30)
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long		id;
		
		@Column(name = "USER_ID", nullable = false)
		private String		userId;
		
		@Column(name = "USERNAME", nullable = false)
		private String		username;
		
		@Column(name = "PASSWORD", nullable = false)
		private String		password;
		
		@Column(name = "SALT", nullable = false, length = 50)
		private String		salt;
		
		@Column(name = "STATUS", nullable = false, length = 50)
		private UserStatus	userStatus	= UserStatus.ACTIVE;
		
		@Column(name = "CREATION_DATE", nullable = false)
		private Long		creationDate;
		
		@Column(name = "LAST_MODIFIED_DATE", nullable = false)
		private Long		lastModifiedDate;
		
		@Column(name = "INVALID_ACCESS_COUNT", nullable = false)
		private Long		invalidAccessCount;
		
		public String getUserId()
			{
				return userId;
			}
			
		public void setUserId(String userId)
			{
				this.userId = userId;
			}
			
		public Long getId()
			{
				return id;
			}
			
		public void setId(Long id)
			{
				this.id = id;
			}
			
		public String getUsername()
			{
				return username;
			}
			
		public void setUsername(String username)
			{
				this.username = username;
			}
			
		public String getPassword()
			{
				return password;
			}
			
		public void setPassword(String password)
			{
				this.password = password;
			}
			
		public String getSalt()
			{
				return salt;
			}
			
		public void setSalt(String salt)
			{
				this.salt = salt;
			}
			
		@PrePersist
		public void perpersist()
			{
				Long creationDate = System.currentTimeMillis();
				this.creationDate = creationDate;
				this.lastModifiedDate = creationDate;
				
			}
			
		@PreUpdate
		public void preupdate()
			{
				Long lastModifiedDate = System.currentTimeMillis();
				this.lastModifiedDate = lastModifiedDate;
			}
			
		public UserLoginMetaData()
			{
				super();
			}
			
		public UserLoginMetaData(String userId, String username, String password, String salt)
			{
				super();
				this.userId = userId;
				this.username = username;
				this.password = password;
				this.salt = salt;
			}
			
	}
