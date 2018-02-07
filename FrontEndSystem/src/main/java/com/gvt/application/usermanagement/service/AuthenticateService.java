package com.gvt.application.usermanagement.service;

public class AuthenticateService
	{
		public static boolean authenticateUser(String username, String password)
			{
				System.out.println("Username "+username);
				System.out.println("Password "+password);
				return true;
			}
	}
