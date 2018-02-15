package com.gvt.application.travelmanagement.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gvt.application.common.entity.dto.Response;
import com.gvt.application.travelmanagement.entity.bo.TravelPlan;
import com.gvt.application.travelmanagement.service.business.TravelPlanService;

@CrossOrigin
@RestController
@RequestMapping(value = "/travelPlan")
public class TravelPlanController
	{
		@Autowired
		private TravelPlanService travelPlanService;
		
		@PostMapping
		public @ResponseBody ResponseEntity<Response<TravelPlan>> post(@RequestBody TravelPlan travelPlan)
			{
				travelPlan = travelPlanService.save(travelPlan);
				return new ResponseEntity<Response<TravelPlan>>(new Response<TravelPlan>(201, "TRAVEL PLAN CREATED", travelPlan), HttpStatus.CREATED);
			}
	}
