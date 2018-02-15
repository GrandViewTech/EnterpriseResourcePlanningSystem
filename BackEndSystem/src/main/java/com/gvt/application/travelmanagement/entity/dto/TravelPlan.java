package com.gvt.application.travelmanagement.entity.dto;

public class TravelPlan
	{
		private Long	id;
		
		private String	token;
		
		private String	name;
		
		private String	description;
		
		public Long getId()
			{
				return id;
			}
			
		public void setId(Long id)
			{
				this.id = id;
			}
			
		public String getToken()
			{
				return token;
			}
			
		public void setToken(String token)
			{
				this.token = token;
			}
			
		public String getName()
			{
				return name;
			}
			
		public void setName(String name)
			{
				this.name = name;
			}
			
		public String getDescription()
			{
				return description;
			}
			
		public void setDescription(String description)
			{
				this.description = description;
			}
			
	}
