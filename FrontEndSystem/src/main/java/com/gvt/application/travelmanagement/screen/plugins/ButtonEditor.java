package com.gvt.application.travelmanagement.screen.plugins;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ButtonEditor extends DefaultCellEditor
	{
		private static final long serialVersionUID = -9125618004425508155L;
		
		public ButtonEditor(JCheckBox checkBox)
			{
				super(checkBox);
			}
			
		public ButtonEditor(JComboBox comboBox)
			{
				super(comboBox);
			}
			
		public ButtonEditor(JTextField textField)
			{
				super(textField);
			}
			
	}
