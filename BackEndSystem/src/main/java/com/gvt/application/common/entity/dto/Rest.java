package com.gvt.application.common.entity.dto;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class Rest<RQ, RS>
	{
		
		private final Logger	LOGGER			= LoggerFactory.getLogger(Rest.class);
		
		
		public ResponseEntity<RS> post(String url, HttpHeaders httpHeaders, RQ data)
			{
				return trigger(HttpMethod.POST, httpHeaders, url, data);
			}
			
		public ResponseEntity<RS> get(String url)
			{
				return trigger(HttpMethod.GET, url, null);
			}
			
		public ResponseEntity<RS> post(String url, RQ data)
			{
				
				return trigger(HttpMethod.POST, url, data);
			}
			
		public ResponseEntity<RS> put(String url, RQ data)
			{
				return trigger(HttpMethod.PUT, url, data);
			}
			
		private HttpHeaders httpHeaders(String requestId)
			{
				HttpHeaders headers = new HttpHeaders();
				headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
				headers.set("requestId", requestId);
				return headers;
			}
			
		private URI uriComponentsBuilder(String url)
			{
				UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
				return builder.build().toUri();
			}
			
		private HttpEntity<RQ> httpEntity(HttpHeaders httpHeaders, RQ data)
			{
				HttpEntity<RQ> httpEntity = new HttpEntity<>(data, httpHeaders);
				return httpEntity;
			}
			
		private ParameterizedTypeReference<RS> parameterizedTypeReference()
			{
				ParameterizedTypeReference<RS> parameterizedTypeReference = new ParameterizedTypeReference<RS>()
					{
					};
				return parameterizedTypeReference;
			}
			
		private ResponseEntity<RS> trigger(HttpMethod httpMethod, String url, RQ data)
			{
				String requestId = "" + System.currentTimeMillis();
				HttpHeaders httpHeaders = httpHeaders(requestId);
				HttpEntity<RQ> httpEntity = httpEntity(httpHeaders, data);
				return trigger(requestId, httpMethod, httpEntity, url);
			}
			
		private ResponseEntity<RS> trigger(HttpMethod httpMethod, HttpHeaders httpHeaders, String url, RQ data)
			{
				String requestId = "" + System.currentTimeMillis();
				httpHeaders.set("requestId", requestId);
				HttpEntity<RQ> httpEntity = httpEntity(httpHeaders, data);
				return trigger(requestId, httpMethod, httpEntity, url);
			}
			
		private ResponseEntity<RS> trigger(String requestId, HttpMethod httpMethod, HttpEntity<RQ> httpEntity, String url)
			{
				
				ResponseEntity<RS> responseEntity = null;
				try
					{
						LOGGER.debug("Requesting  " + url + " with method type " + httpMethod.name() + " with RequestId : " + requestId + " body :" + httpEntity.getBody());
						org.springframework.http.client.SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new org.springframework.http.client.SimpleClientHttpRequestFactory();
						simpleClientHttpRequestFactory.setOutputStreaming(false);
						RestTemplate restTemplate = new RestTemplate(simpleClientHttpRequestFactory);
						responseEntity = restTemplate.exchange(uriComponentsBuilder(url), httpMethod, httpEntity, parameterizedTypeReference());
						LOGGER.debug("Response Received from  " + url + " with method type " + httpMethod.name() + " http status : " + responseEntity.getStatusCode().value() + " | " + responseEntity.getStatusCode().getReasonPhrase());
					}
				catch (ResourceAccessException resourceAccessException)
					{
						LOGGER.error("Exception : ", resourceAccessException);
						responseEntity = new ResponseEntity<>(null, HttpStatus.SERVICE_UNAVAILABLE);
					}
				catch (HttpClientErrorException httpClientErrorException)
					{
						String json = httpClientErrorException.getResponseBodyAsString();
						LOGGER.error("Error Body : "+json);
						LOGGER.error(responseEntity.toString());
						responseEntity = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
					}
				catch (Exception e)
					{
						LOGGER.error("Exception : ", e.getMessage());
						responseEntity = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
					}
				return responseEntity;
			}
	}
