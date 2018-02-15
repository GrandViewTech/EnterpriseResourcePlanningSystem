package com.gvt.application.common.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Puneets
 *
 */
@JsonIgnoreProperties(allowGetters = true, ignoreUnknown = true)
public class ResponseError
	{
		
		private String	message;
		
		private Integer	code;
		
		@JsonProperty(value = "message")
		public String getMessage()
			{
				return message;
			}
			
		@JsonProperty(value = "code")
		public Integer getCode()
			{
				return code;
			}
			
		public ResponseError(Integer code, String message)
			{
				super();
				this.message = message;
				this.code = code;
			}
			
		public ResponseError()
			{
				super();
			}
			
		@Override
		public String toString()
			{
				return "Error [message=" + message + ", code=" + code + "]";
			}
			
	}
