package com.gvt.application.screen;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class BackGroudScreen extends JFrame
	{
		
		private static final long	serialVersionUID	= -1644700763804578594L;
		
		private JTabbedPane			tabbedPane			= new JTabbedPane();
		
		public BackGroudScreen()
			{
				super("Enterprise Application");
				setSize(500, 400);
				setExtendedState(JFrame.MAXIMIZED_BOTH);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setVisible(true);
				setLocationRelativeTo(null);
				getContentPane().setBackground(Color.WHITE);
				addComponent();
			}
			
		private void addComponent()
			{
				
				tabbedPane.addTab("Dashboard", new Dashboard());
				tabbedPane.addTab("Dealer Management", new DealerScreen());
				add(tabbedPane);
			}
			
	}
