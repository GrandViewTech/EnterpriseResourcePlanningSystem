package com.gvt.application.common.entity.exception;

public class RestException extends RuntimeException
	{
		private static final long serialVersionUID = 6474568568830236446L;
		
		public RestException()
			{
				super();
			}
			
		public RestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
			{
				super(message, cause, enableSuppression, writableStackTrace);
			}
			
		public RestException(String message, Throwable cause)
			{
				super(message, cause);
			}
			
		public RestException(String message)
			{
				super(message);
			}
			
		public RestException(Throwable cause)
			{
				super(cause);
			}
			
	}
