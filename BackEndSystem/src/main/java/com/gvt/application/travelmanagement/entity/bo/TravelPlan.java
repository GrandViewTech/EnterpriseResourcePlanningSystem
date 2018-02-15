package com.gvt.application.travelmanagement.entity.bo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "TRAVEL_PLAN")
public class TravelPlan
	{
		@Id
		@Column(name = "ID", length = 30)
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long						id;
		
		@Column(name = "PLAN_ID", nullable = false, unique = true)
		private String						planId;
		
		@Column(name = "USER_ID", nullable = true)
		private String						userId;
		
		@Column(name = "NAME_PLAN", nullable = true)
		private String						name;
		
		@Column(name = "DESCRIPTION", nullable = true)
		private String						description;
		
		@Column(name = "START_DATE", nullable = true)
		private Long						startDate;
		
		@Column(name = "END_DATE", nullable = true)
		private Long						endDate;
		
		@Column(name = "CREATION_DATE", nullable = true)
		private Long						creationDate;
		
		@Column(name = "LAST_MODIFIED_DATE", nullable = true)
		private Long						lastModifiedDate;
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "travelPlan", fetch = FetchType.EAGER)
		private List<TravelPlanItinerary>	travelPlanItineraries;
		
		public List<TravelPlanItinerary> getTravelPlanItineraries()
			{
				return travelPlanItineraries;
			}
			
		public void setTravelPlanItineraries(List<TravelPlanItinerary> travelPlanItineraries)
			{
				this.travelPlanItineraries = travelPlanItineraries;
			}
			
		public Long getStartDate()
			{
				return startDate;
			}
			
		public void setStartDate(Long startDate)
			{
				this.startDate = startDate;
			}
			
		public Long getEndDate()
			{
				return endDate;
			}
			
		public void setEndDate(Long endDate)
			{
				this.endDate = endDate;
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
			
		public String getPlanId()
			{
				return planId;
			}
			
		public void setPlanId(String planId)
			{
				this.planId = planId;
			}
			
		public Long getCreationDate()
			{
				return creationDate;
			}
			
		public void setCreationDate(Long creationDate)
			{
				this.creationDate = creationDate;
			}
			
		public Long getLastModifiedDate()
			{
				return lastModifiedDate;
			}
			
		public void setLastModifiedDate(Long lastModifiedDate)
			{
				this.lastModifiedDate = lastModifiedDate;
			}
			
		@PrePersist
		public void preinsert()
			{
				Long date = System.currentTimeMillis();
				this.creationDate = date;
				this.lastModifiedDate = date;
			}
			
		@PreUpdate
		public void preUpdate()
			{
				Long date = System.currentTimeMillis();
				this.lastModifiedDate = date;
			}
	}
