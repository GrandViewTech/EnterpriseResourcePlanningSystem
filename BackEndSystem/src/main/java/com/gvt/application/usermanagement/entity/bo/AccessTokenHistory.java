package com.gvt.application.usermanagement.entity.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCESS_TOKEN_HISTORY")
public class AccessTokenHistory
	{
		@Id
		@Column(name = "ID", length = 30)
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long	id;
		
		@Column(name = "USER_ID", length = 100, nullable = false)
		private String	userId;
		
		@Column(name = "TOKEN", length = 500, nullable = false)
		private String	token;
		
		@Column(name = "CREATION_DATE", length = 25, nullable = false)
		private Long	createdOn;
		
		@Column(name = "REVOKED_ON", length = 25, nullable = false)
		private Long	revokedOn=-1L;
		
		public Long getId()
			{
				return id;
			}
			
		public void setId(Long id)
			{
				this.id = id;
			}
			
		public String getUserId()
			{
				return userId;
			}
			
		public void setUserId(String userId)
			{
				this.userId = userId;
			}
			
		public String getToken()
			{
				return token;
			}
			
		public void setToken(String token)
			{
				this.token = token;
			}
			
		public Long getCreatedOn()
			{
				return createdOn;
			}
			
		public void setCreatedOn(Long createdOn)
			{
				this.createdOn = createdOn;
			}
			
		public Long getRevokedOn()
			{
				return revokedOn;
			}
			
		public void setRevokedOn(Long revokedOn)
			{
				this.revokedOn = revokedOn;
			}
			
		public AccessTokenHistory()
			{
				super();
			}
			
		public AccessTokenHistory(String userId, String token, Long createdOn)
			{
				super();
				this.userId = userId;
				this.token = token;
				this.createdOn = createdOn;
			}
			
		public AccessTokenHistory update(Long revokedOn)
			{
				this.revokedOn = revokedOn;
				return this;
			}
			
	}
