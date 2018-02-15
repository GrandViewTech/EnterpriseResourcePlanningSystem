package com.gvt.application.common.screen.plugins.datepicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFormattedTextField.AbstractFormatter;

import com.gvt.application.common.entity.constants.ConstantData;

public class DateLabelFormatter extends AbstractFormatter
	{
		
		private static final long	serialVersionUID	= -935144092782380156L;
		
		private SimpleDateFormat	dateFormatter		= new SimpleDateFormat(ConstantData.DATE_PATTERN);
		
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
