package com.gvt.application.screen.plugins.datepicker;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFormattedTextField.AbstractFormatter;

public class DateLabelFormatter extends AbstractFormatter
	{
		
		private static final long	serialVersionUID	= -935144092782380156L;
		
		private String				datePattern			= "dd-MM-yyyy";
		private SimpleDateFormat	dateFormatter		= new SimpleDateFormat(datePattern);
		
		@Override
		public Object stringToValue(String text) throws ParseException
			{
				return dateFormatter.parseObject(text);
			}
			
		@Override
		public String valueToString(Object value) throws ParseException
			{
				if (value != null)
					{
						if (value instanceof Calendar)
							{
								Calendar date = (Calendar) value;
								return dateFormatter.format(date.getTime());
							}
						if (value instanceof Date)
							{
								Date date = (Date) value;
								return dateFormatter.format(date);
							}
							
					}
					
				return "";
			}
			
	}
