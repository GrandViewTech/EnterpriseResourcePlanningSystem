package com.gvt.application.common.service.plugins;

import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gvt.application.common.entity.dto.Response;

public class Restplugin
	{
		
		private static ObjectMapper	objectMapper					= new ObjectMapper();
		
		public static HttpHeaders	HTTP_HEADER_APPLICATION_JSON	= new HttpHeaders();
		
		public static RestTemplate getRestTemplate()
			{
				RestTemplate restTemplate = new RestTemplate();
				MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
				messageConverter.setPrettyPrint(false);
				objectMapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
				messageConverter.setObjectMapper(objectMapper);
				restTemplate.getMessageConverters().removeIf(m -> m.getClass().getName().equals(MappingJackson2HttpMessageConverter.class.getName()));
				restTemplate.getMessageConverters().add(messageConverter);
				return restTemplate;
			}
			
		public static RestTemplate getRestTemplate2()
			{
				org.springframework.http.client.SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new org.springframework.http.client.SimpleClientHttpRequestFactory();
				simpleClientHttpRequestFactory.setOutputStreaming(false);
				RestTemplate restTemplate = new RestTemplate(simpleClientHttpRequestFactory);
				return restTemplate;
			}
			
		final public static ParameterizedTypeReference<Response<List<Map<String, Object>>>>	BASIC_TYPED_REFERENCE_2	= new ParameterizedTypeReference<Response<List<Map<String, Object>>>>()
																														{
																														};
		
		final public static ParameterizedTypeReference<Response<Map<String, Object>>>		BASIC_TYPED_REFERENCE	= new ParameterizedTypeReference<Response<Map<String, Object>>>()
																														{
																														};
		static
			{
				HTTP_HEADER_APPLICATION_JSON.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
			}
			
	}
