package com.gvt.application.usermanagement.screen;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.gvt.application.screen.BackGroudScreen;
import com.gvt.application.usermanagement.service.AuthenticateService;

public class LoginScreen extends JFrame
	{
		private static final long	serialVersionUID	= 1L;
		
		private JPanel				panel				= new JPanel();
		
		private JLabel				userLabel			= new JLabel("Username : ");
		
		private JTextField			userTextField		= new JTextField();
		
		private JLabel				passwordLabel		= new JLabel("Password : ");
		
		private JPasswordField		userPasswordField	= new JPasswordField();
		
		private JButton				submitButton		= new JButton("Login");
		
		private JButton				cancelButton		= new JButton("Cancel");
		
		public LoginScreen()
			{
				super("Vinayakka Textile Agency");
				setSize(500, 400);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setVisible(true);
				setLocationRelativeTo(null);
				loadcomponent();
				addListeners();
			}
			
		private void loadcomponent()
			{
				panel.setLayout(null);
				userLabel.setBounds(10, 200, 200, 25);
				panel.add(userLabel);
				userTextField.setBounds(250, 200, 200, 25);
				panel.add(userTextField);
				passwordLabel.setBounds(10, 250, 200, 25);
				panel.add(passwordLabel);
				userPasswordField.setBounds(250, 250, 200, 25);
				panel.add(userPasswordField);
				submitButton.setBounds(10, 300, 150, 25);
				panel.add(submitButton);
				// cancelButton.setPreferredSize(new Dimension(10, 10));
				cancelButton.setBounds(250, 300, 150, 25);
				panel.add(cancelButton);
				add(panel);
			}
			
		private void addListeners()
			{
				submitButton.addActionListener(action ->
					{
						String username = userTextField.getText();
						String password = new String(userPasswordField.getPassword());
						if (AuthenticateService.authenticateUser(username, password))
							{
								dispose();
								BackGroudScreen backGroudScreen = new BackGroudScreen();
							}
					});
				cancelButton.addActionListener(action ->
					{
						dispose();
					});
			}
	}
