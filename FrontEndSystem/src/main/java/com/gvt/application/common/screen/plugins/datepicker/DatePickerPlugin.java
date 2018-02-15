package com.gvt.application.common.screen.plugins.datepicker;

import java.util.Properties;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class DatePickerPlugin
	{
		public static JDatePickerImpl datePicker()
			{
				Properties properties = new Properties();
				properties.put("text.today", "Today");
				properties.put("text.month", "Month");
				properties.put("text.year", "Year");
				UtilDateModel model = new UtilDateModel();
				JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
				return new JDatePickerImpl(datePanel, new DateLabelFormatter());
			}
	}
