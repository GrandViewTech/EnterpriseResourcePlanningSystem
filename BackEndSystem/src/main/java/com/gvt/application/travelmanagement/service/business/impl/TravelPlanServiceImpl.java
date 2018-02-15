package com.gvt.application.travelmanagement.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gvt.application.travelmanagement.entity.bo.TravelPlan;
import com.gvt.application.travelmanagement.entity.bo.TravelPlanItinerary;
import com.gvt.application.travelmanagement.service.business.TravelPlanService;
import com.gvt.application.travelmanagement.service.repository.TravelPlanRepository;

@Service
public class TravelPlanServiceImpl implements TravelPlanService
	{
		@Autowired
		private TravelPlanRepository planRepository;
		
		@Override
		public TravelPlan save(TravelPlan travelPlan)
			{
				String planId = "PL_" + System.currentTimeMillis();
				travelPlan.setPlanId(planId);
				for (TravelPlanItinerary travelPlanItinerary : travelPlan.getTravelPlanItineraries())
					{
						travelPlanItinerary.setTravelPlan(travelPlan);
					}
				return planRepository.save(travelPlan);
			}
	}
