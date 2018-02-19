package com.gvt.application.usermanagement.entity.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SignUpDto implements Serializable
	{
		
		private static final long	serialVersionUID	= 1L;
		
		private String				username;
		
		private String				password;
		
		private String				primaryEmailAddress;
		
		private String				primaryMobileNumber;
		
		public String getPrimaryEmailAddress()
			{
				return primaryEmailAddress;
			}
			
		public void setPrimaryEmailAddress(String primaryEmailAddress)
			{
				this.primaryEmailAddress = primaryEmailAddress;
			}
			
		public String getPrimaryMobileNumber()
			{
				return primaryMobileNumber;
			}
			
		public void setPrimaryMobileNumber(String primaryMobileNumber)
			{
				this.primaryMobileNumber = primaryMobileNumber;
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

		public SignUpDto()
			{
				super();
			}
 
			
		
	}
