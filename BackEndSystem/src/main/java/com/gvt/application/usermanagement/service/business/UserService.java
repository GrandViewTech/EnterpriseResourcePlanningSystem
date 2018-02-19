package com.gvt.application.usermanagement.service.business;

import com.gvt.application.usermanagement.entity.dto.SignUpDto;

public interface UserService
	{

	void createUser(SignUpDto signUp);

	String login(String string, String string2);
			
	}
