package com.gvt.application.usermanagement.entity.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "ACCESS_TOKEN")
public class AccessToken
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
		
		@Column(name = "LONGEVITY", length = 25, nullable = false)
		private int		longevity	;
		
		public void setLongevity(int longevity)
			{
				this.longevity = longevity;
			}
			
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
			
		public int getLongevity()
			{
				return longevity;
			}
			
		public AccessToken()
			{
				super();
			}
			
		public AccessToken(String userId, String token, int longevity)
			{
				super();
				this.userId = userId;
				this.token = token;
				this.longevity = longevity;
			}
			
		@PrePersist
		public void prepersist()
			{
				createdOn = System.currentTimeMillis();
			}
			
	}
