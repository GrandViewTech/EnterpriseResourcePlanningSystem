package com.gvt.application.screen.travelmanagement.plugins;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer extends JButton implements TableCellRenderer
	{
		public ButtonRenderer()
			{
				setOpaque(true);
			}
			
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
			{
				// TODO Auto-generated method stub
				return null;
			}
			
	}
