package com.gvt.application.travelmanagement.screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePickerImpl;

import com.gvt.application.common.entity.constants.ConstantData;
import com.gvt.application.common.screen.ScreenPlay;
import com.gvt.application.common.screen.plugins.ScreenPlugin;
import com.gvt.application.common.screen.plugins.datepicker.DatePickerPlugin;
import com.gvt.application.travelmanagement.service.TravelPlanService;

public class MyPlan extends JPanel implements ScreenPlay
	{
		
		private static final long		serialVersionUID		= 5885077564772960804L;
		
		private JLabel					planLabel				= new JLabel("Plan For : ");
		private JTextField				planJTextField			= new JTextField("");
		
		private JLabel					startDateLabel			= new JLabel("Start Date : ");
		private JLabel					endDateLabel			= new JLabel("End Date : ");
		
		private JButton					itineraryButton			= new JButton("Itinerary");
		
		private JButton					submitYourPlanButton	= new JButton("Submit");
		
		private JButton					cancelYourPlan			= new JButton("cancel");
		
		private DefaultTableModel		defaultTableModel		= new DefaultTableModel();
		
		public JTable					itineraryTable			= new JTable(defaultTableModel)
																	{
																		private static final long serialVersionUID = -1783785805801655908L;
																		
																		public boolean isCellEditable(int row, int column)
																			{
																				return false;
																			};
																	};
		private int						heightPadding			= 50;
		public JFrame					parentFrame;
		private ItineraryInputScreen	itineraryInputScreen;
		private JDatePickerImpl			startDatePicker			= null;
		private JDatePickerImpl			endDatePicker			= null;
		private MyPlan					myPlan					= null;
		
		public ItineraryInputScreen getItineraryInputScreen()
			{
				return itineraryInputScreen;
			}
			
		public void setItineraryInputScreen(ItineraryInputScreen itineraryInputScreen)
			{
				this.itineraryInputScreen = itineraryInputScreen;
			}
			
		public DefaultTableModel getDefaultTableModel()
			{
				return defaultTableModel;
			}
			
		public MyPlan(JFrame parentFrame)
			{
				myPlan = this;
				this.parentFrame = parentFrame;
				addBody();
				addListeners();
			}
			
		@Override
		public void addBody()
			{
				setLayout(null);
				setVisible(true);
				setSize(new Dimension(800, 500));
				setBackground(Color.WHITE);
				int i = 0;
				i = addPlanInfo(i);
				i = addStartAndEndDate(i);
				ScreenPlugin.add(this, itineraryButton, 50, heightPadding * (i = i + 1), 100, 25);
				i = addTable(i);
				ScreenPlugin.add(this, submitYourPlanButton, 100, heightPadding * (i = i + 1), 100, 25);
				ScreenPlugin.add(this, cancelYourPlan, 250, heightPadding * (i), 100, 25);
				
			}
			
		private int addPlanInfo(int i)
			{
				i = i + 1;
				ScreenPlugin.add(this, planLabel, 50, heightPadding * i, 100, 25);
				ScreenPlugin.add(this, planJTextField, 140, heightPadding * i, 100, 25);
				return i;
			}
			
		private int addStartAndEndDate(int i)
			{
				i = i + 1;
				ScreenPlugin.add(this, startDateLabel, 50, heightPadding * (i), 100, 25);
				startDatePicker = DatePickerPlugin.datePicker();
				ScreenPlugin.add(this, startDatePicker, 140, heightPadding * (i), 150, 25);
				ScreenPlugin.add(this, endDateLabel, 320, heightPadding * (i), 100, 25);
				endDatePicker = DatePickerPlugin.datePicker();
				ScreenPlugin.add(this, endDatePicker, 410, heightPadding * (i), 150, 25);
				return i;
			}
			
		private int addTable(int i)
			{
				defaultTableModel.addColumn("SR NO.");
				defaultTableModel.addColumn("DATE");
				defaultTableModel.addColumn("FROM");
				defaultTableModel.addColumn("TO");
				defaultTableModel.addColumn("PURPOSE");
				defaultTableModel.addColumn("EDIT");
				defaultTableModel.addColumn("REMOVE");
				itineraryTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				itineraryTable.setAutoscrolls(true);
				itineraryTable.setSize(new Dimension(650, 200));
				JScrollPane scrollPane = new JScrollPane(itineraryTable);
				ScreenPlugin.add(this, scrollPane, 50, heightPadding * (i = i + 1), 650, 130);
				i = i + 2;
				return i;
			}
			
		@Override
		public void addListeners()
			{
				itineraryButton.addActionListener(click ->
					{
						
						if (itineraryInputScreen == null)
							{
								itineraryInputScreen = new ItineraryInputScreen(this);
							}
						else
							{
								itineraryInputScreen.toFront();
							}
					});
				
				cancelYourPlan.addActionListener(cancel ->
					{
						if (parentFrame != null)
							{
								parentFrame.dispose();
							}
					});
				itineraryTable.addMouseListener(new MouseAdapter()
					{
						@Override
						public void mouseClicked(MouseEvent mouseEvent)
							{
								super.mouseClicked(mouseEvent);
								int row = itineraryTable.rowAtPoint(mouseEvent.getPoint());
								int col = itineraryTable.columnAtPoint(mouseEvent.getPoint());
								if (col == 5)
									{
										int i = JOptionPane.showConfirmDialog(null, "Do You wish to Edit", "Update Itinerary", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
										if (i == 0)
											{
												itineraryInputScreen = new ItineraryInputScreen(myPlan);
												itineraryInputScreen.edit(new String[]
													{ "" + row, "" + defaultTableModel.getValueAt(row, 1), "" + defaultTableModel.getValueAt(row, 2), "" + defaultTableModel.getValueAt(row, 3), "" + defaultTableModel.getValueAt(row, 4), "" + defaultTableModel.getValueAt(row, 5) });
												itineraryInputScreen.setAlwaysOnTop(true);
												itineraryInputScreen.toFront();
												
											}
									}
								if (col == 6)
									{
										int i = JOptionPane.showConfirmDialog(null, "Do You wish to Delete", "Delete Itinerary", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
										if (i == 0)
											{
												defaultTableModel.removeRow(row);
											}
									}
							}
					});
				submitYourPlanButton.addActionListener(submit ->
					{
						try
							{
								List<Map<String, Object>> travelPlanItineraries = new ArrayList<>();
								for (int rowCount = 0; rowCount < defaultTableModel.getRowCount(); rowCount++)
									{
										Map<String, Object> travelPlanItinerary = new HashMap<>();
										travelPlanItinerary.put("date", (new SimpleDateFormat(ConstantData.DATE_PATTERN).parse("" + defaultTableModel.getValueAt(rowCount, 1)).getTime()));
										travelPlanItinerary.put("from", defaultTableModel.getValueAt(rowCount, 2));
										travelPlanItinerary.put("to", defaultTableModel.getValueAt(rowCount, 3));
										travelPlanItinerary.put("purpose", defaultTableModel.getValueAt(rowCount, 4));
										travelPlanItineraries.add(travelPlanItinerary);
									}
								int i = JOptionPane.showConfirmDialog(null, "Do You wish to Submit You Travel Plan for Approval", "Submit Your Travel Plan", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
								if (i == 0)
									{
										
										Map<String, Object> travelPlan = new HashMap<>();
										travelPlan.put("userId", UUID.randomUUID().toString());
										travelPlan.put("name", ("" + planJTextField.getText()).trim());
										travelPlan.put("description", "");
										travelPlan.put("startDate", (new SimpleDateFormat(ConstantData.DATE_PATTERN).parse(startDatePicker.getJFormattedTextField().getText()).getTime()));
										travelPlan.put("endDate", (new SimpleDateFormat(ConstantData.DATE_PATTERN).parse(endDatePicker.getJFormattedTextField().getText()).getTime()));
										travelPlan.put("travelPlanItineraries", travelPlanItineraries);
										TravelPlanService.submit(travelPlan);
										parentFrame.dispose();
										
									}
							}
						catch (Exception exception)
							{
								exception.printStackTrace();
							}
							
					});
			}
			
	}
