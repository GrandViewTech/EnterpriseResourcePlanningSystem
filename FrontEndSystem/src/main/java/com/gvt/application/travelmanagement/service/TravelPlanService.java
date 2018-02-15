package com.gvt.application.travelmanagement.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.gvt.application.common.entity.dto.Response;
import com.gvt.application.common.entity.dto.Rest;
import com.gvt.application.common.service.plugins.Restplugin;

public class TravelPlanService
	{
		private static final Logger	LOGGER			= LoggerFactory.getLogger(TravelPlanService.class);
		 
		public static String submit(Map<String, Object> travelPlan)
			{
				String planId="";
				String url = "http://localhost:8096/grandviewtech/erp/travelPlan";
				RestTemplate restTemplate = Restplugin.getRestTemplate();
				ResponseEntity<Response<Map<String, Object>>> responseEntity = restTemplate.exchange(new RequestEntity<Map<String, Object>>(travelPlan, HttpMethod.POST, UriComponentsBuilder.fromHttpUrl(url).build().toUri()), Restplugin.BASIC_TYPED_REFERENCE);
				Map<String, Object> payload = new HashMap<>();
				if (responseEntity.getStatusCode().is2xxSuccessful())
					{
						Response<Map<String, Object>> response = responseEntity.getBody();
						payload = response.getPayload();
						planId=""+payload.get("planId");
					}
				LOGGER.info("PlanId "+planId);
				return planId;
			}
	}
