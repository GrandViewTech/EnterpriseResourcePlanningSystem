package com.gvt.application.usermanagement.client;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gvt.application.usermanagement.entity.dto.SignUpDto;
import com.gvt.application.usermanagement.service.business.UserService;

@RestController
@CrossOrigin
public class UserController
	{
		@Autowired
		private UserService userService;
		
		@PostMapping(value = "/signup")
		public void signUp(@RequestBody SignUpDto signUp)
			{
				userService.createUser(signUp);
			}
			
		@PostMapping(value = "/login")
		public String login(@RequestBody Map<String, String> request)
			{
				String token = userService.login("" + request.get("username"), "" + request.get("password"));
				return token;
			}
	}
