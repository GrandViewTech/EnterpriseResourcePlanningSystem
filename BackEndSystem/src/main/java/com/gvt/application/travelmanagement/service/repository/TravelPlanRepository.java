package com.gvt.application.travelmanagement.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gvt.application.travelmanagement.entity.bo.TravelPlan;

@Repository
public interface TravelPlanRepository extends CrudRepository<TravelPlan, String>
	{
		
	}
