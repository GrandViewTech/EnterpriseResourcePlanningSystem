package com.gvt.application.travelmanagement.entity.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TRAVEL_PLAN_ITINERARY")
public class TravelPlanItinerary
	{
		
		@Id
		@Column(name = "ID")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long		id;
		
		@Column(name = "TRAVEL_DATE", nullable = false)
		private Long		date;
		
		@Column(name = "TRAVEL_FROM", nullable = false)
		private String		from;
		
		@Column(name = "TRAVEL_TO", nullable = false)
		private String		to;
		
		@Column(name = "TRAVEL_PURPOSE", nullable = false, length = 1000)
		private String		purpose;
		
		@JsonIgnore
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "TRAVEL_PLAN_ID", nullable = true)
		private TravelPlan	travelPlan;
		
		public TravelPlan getTravelPlan()
			{
				return travelPlan;
			}
			
		public void setTravelPlan(TravelPlan travelPlan)
			{
				this.travelPlan = travelPlan;
			}
			
		public Long getId()
			{
				return id;
			}
			
		public void setId(Long id)
			{
				this.id = id;
			}
			
		public Long getDate()
			{
				return date;
			}
			
		public void setDate(Long date)
			{
				this.date = date;
			}
			
		public String getFrom()
			{
				return from;
			}
			
		public void setFrom(String from)
			{
				this.from = from;
			}
			
		public String getTo()
			{
				return to;
			}
			
		public void setTo(String to)
			{
				this.to = to;
			}
			
		public String getPurpose()
			{
				return purpose;
			}
			
		public void setPurpose(String purpose)
			{
				this.purpose = purpose;
			}
			
	}
