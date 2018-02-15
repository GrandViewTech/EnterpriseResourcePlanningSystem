package com.gvt.application.screen.travelmanagement;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePickerImpl;

import com.gvt.application.screen.ScreenPlay;
import com.gvt.application.screen.plugins.ScreenPlugin;
import com.gvt.application.screen.plugins.datepicker.DatePickerPlugin;

public class ItineraryInputScreen extends JFrame implements ScreenPlay
	{
		
		private static final long	serialVersionUID	= -5793573742723648284L;
		private JPanel				panel				= new JPanel();
		
		private JLabel				dateLabel			= new JLabel("Date :");
		private JDatePickerImpl		datePicker			= null;
		private JLabel				fromLabel			= new JLabel("From :");
		private JTextField			fromJtextField		= new JTextField();
		private JLabel				toLabel				= new JLabel("To : ");
		private JTextField			toJtextField		= new JTextField();
		private JLabel				purposeLabel		= new JLabel("Purpose : ");
		private JTextField			purposeJtextField	= new JTextField();
		private JButton				submitButton		= new JButton("Submit");
		private JButton				cancelButton		= new JButton("Cancel");
		private DefaultTableModel	defaultTableModel;
		private int					heightPadding		= 50;
		private Dimension			dimension			= new Dimension(400, 400);
		private MyPlan				myplan;
		private int					defaultX1			= 50;
		private int					defaultX2			= 170;
		private int					rowIndex			= -1;
		
		public ItineraryInputScreen(MyPlan myplan)
			{
				super("Add Travel Itinerary");
				this.defaultTableModel = myplan.getDefaultTableModel();
				this.myplan = myplan;
				defaultBehavior();
				addBody();
				addListeners();
			}
			
		@Override
		public void addBody()
			{
				int i = 0;
				i = addDate(i);
				i = addFrom(i);
				i = addTo(i);
				i = addPurpose(i);
				i = addSubmitAndCancel(i);
			}
			
		private void defaultBehavior()
			{
				// setLayout(null);
				setLocationRelativeTo(null);
				setVisible(true);
				setSize(dimension);
				setResizable(false);
				addPanel();
			}
			
		private void addPanel()
			{
				panel.setPreferredSize(dimension);
				panel.setLayout(null);
				panel.setVisible(true);
				panel.setBackground(Color.WHITE);
				add(panel);
			}
			
		private int addDate(int i)
			{
				i = i + 1;
				ScreenPlugin.add(panel, dateLabel, defaultX1, heightPadding * i, 100, 24);
				datePicker = DatePickerPlugin.datePicker();
				ScreenPlugin.add(panel, datePicker, defaultX2, heightPadding * i, 100, 24);
				return i;
			}
			
		private int addFrom(int i)
			{
				i = i + 1;
				ScreenPlugin.add(panel, fromLabel, defaultX1, heightPadding * i, 100, 24);
				ScreenPlugin.add(panel, fromJtextField, defaultX2, heightPadding * i, 100, 24);
				return i;
			}
			
		private int addTo(int i)
			{
				i = i + 1;
				ScreenPlugin.add(panel, toLabel, defaultX1, heightPadding * i, 100, 24);
				ScreenPlugin.add(panel, toJtextField, defaultX2, heightPadding * i, 100, 24);
				return i;
			}
			
		private int addPurpose(int i)
			{
				i = i + 1;
				ScreenPlugin.add(panel, purposeLabel, defaultX1, heightPadding * i, 100, 24);
				ScreenPlugin.add(panel, purposeJtextField, defaultX2, heightPadding * i, 100, 24);
				return i;
			}
			
		private int addSubmitAndCancel(int i)
			{
				i = i + 1;
				ScreenPlugin.add(panel, submitButton, 50, heightPadding * i, 100, 24);
				ScreenPlugin.add(panel, cancelButton, 170, heightPadding * i, 100, 24);
				return i;
			}
			
		@Override
		public void addListeners()
			{
				submitButton.addActionListener(submit ->
					{
						int index = defaultTableModel.getRowCount() + 1;
						if (rowIndex < 0)
							{
								defaultTableModel.addRow(new Object[]
									{ index, datePicker.getJFormattedTextField().getText(), fromJtextField.getText(), toJtextField.getText(), purposeJtextField.getText(), "EDIT", "REMVOE" });
							}
						else
							{
								defaultTableModel.setValueAt(datePicker.getJFormattedTextField().getText(), rowIndex, 1);
								defaultTableModel.setValueAt(fromJtextField.getText(), rowIndex, 2);
								defaultTableModel.setValueAt(toJtextField.getText(), rowIndex, 3);
								defaultTableModel.setValueAt(purposeJtextField.getText(), rowIndex, 4);
							}
						dispose();
						myplan.setItineraryInputScreen(null);
					});
				cancelButton.addActionListener(cancel ->
					{
						dispose();
						myplan.setItineraryInputScreen(null);
					});
				
			}
			
		public void edit(String[] existingData)
			{
				rowIndex = new Integer(existingData[0]);
				datePicker.getJFormattedTextField().setText(existingData[1]);
				fromJtextField.setText(existingData[2]);
				toJtextField.setText(existingData[3]);
				purposeJtextField.setText(existingData[4]);
			}
	}
