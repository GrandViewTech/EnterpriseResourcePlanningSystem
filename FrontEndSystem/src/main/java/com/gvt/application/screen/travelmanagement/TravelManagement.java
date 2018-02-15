package com.gvt.application.screen.travelmanagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.gvt.application.screen.ScreenPlay;

public class TravelManagement extends JPanel implements ScreenPlay
	{
		
		private static final long	serialVersionUID		= 1L;
		
		private JButton				submitYourTravelPlan	= new JButton("Submit Your Travel Plan");
		
		public TravelManagement()
			{
				addBody();
			}
			
		@Override
		public void addBody()
			{
				setVisible(true);
				setBackground(Color.WHITE);
				setLayout(null);
				submitYourTravelPlan.setBounds(10, 20, 100, 25);
				add(submitYourTravelPlan);
				addListeners();
			}
			
		@Override
		public void addListeners()
			{
				submitYourTravelPlan.addActionListener(click ->
					{
						Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
						Point middle = new Point(screenSize.width / 2, screenSize.height / 2);
						Point newLocation = new Point((middle.x - (getWidth() / 2)) * 2, (middle.y - (getHeight() / 2)) * 2);
						JFrame jFrame = new JFrame("My Plan");
						jFrame.setLayout(null);
						// jFrame.setLocationRelativeTo(null);
						jFrame.setLocation(newLocation);
						jFrame.setVisible(true);
						jFrame.setSize(new Dimension(800, 500));
						// jFrame.setResizable(false);
						jFrame.setBackground(Color.WHITE);
						jFrame.add(new MyPlan(jFrame));
					});
			}
			
	}
