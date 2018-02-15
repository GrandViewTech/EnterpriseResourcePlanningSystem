package com.gvt.application.common.entity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> implements Serializable
	{
		private static final long	serialVersionUID	= -3652820743130575693L;
		
		@JsonProperty(value = "payload")
		private T					payload;
		@JsonProperty(value = "responseCode")
		private Integer				responseCode		= 200;;
		@JsonProperty(value = "message")
		private String				message				= HttpStatus.OK.getReasonPhrase();
		
		@JsonProperty(value = "errors")
		private List<ResponseError>	errors				= new ArrayList<ResponseError>();
		
		public Response(Integer responseCode, String message, T payload, List<ResponseError> errors)
			{
				this.responseCode = responseCode;
				this.message = message;
				this.payload = payload;
				this.errors = errors;
			}
		
		
		public Response(Integer responseCode, String message, T payload)
			{
				this.responseCode = responseCode;
				this.message = message;
				this.payload = payload;
			}
			
		public T getPayload()
			{
				return payload;
			}
			
		public void setPayload(T payload)
			{
				this.payload = payload;
			}
			
		public Integer getResponseCode()
			{
				return responseCode;
			}
			
		public void setResponseCode(Integer responseCode)
			{
				this.responseCode = responseCode;
			}
			
		public String getMessage()
			{
				return message;
			}
			
		public void setMessage(String message)
			{
				this.message = message;
			}
			
		public Response()
			{
				super();
			}
			
	}
