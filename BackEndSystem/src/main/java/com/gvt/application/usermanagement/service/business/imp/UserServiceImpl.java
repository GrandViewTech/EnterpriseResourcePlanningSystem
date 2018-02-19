package com.gvt.application.usermanagement.service.business.imp;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gvt.application.usermanagement.entity.bo.UserLoginMetaData;
import com.gvt.application.usermanagement.entity.dto.SignUpDto;
import com.gvt.application.usermanagement.service.business.AccessTokenService;
import com.gvt.application.usermanagement.service.business.UserService;
import com.gvt.application.usermanagement.service.repository.UserLoginMetaDataRepository;

@Service("userService")
public class UserServiceImpl implements UserService
	{
		@Autowired
		private UserLoginMetaDataRepository	userLoginMetaDataRepository;
		
		@Autowired
		private AccessTokenService			accessTokenService;
		
		@Override
		@Transactional(propagation = Propagation.REQUIRES_NEW)
		public void createUser(SignUpDto signUp)
			{
				String username = signUp.getUsername();
				UserLoginMetaData loginMetaData = userLoginMetaDataRepository.findByUsernameIgnoreCase(username);
				if (loginMetaData == null)
					{
						String salt = "" + UUID.randomUUID().toString().hashCode();
						String password = signUp.getPassword();
						password = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password + salt);
						loginMetaData = new UserLoginMetaData("" + System.currentTimeMillis(), username, password, salt);
						userLoginMetaDataRepository.save(loginMetaData);
					}
			}
			
		@Override
		@Transactional(propagation = Propagation.REQUIRES_NEW)
		public String login(String username, String password)
			{
				UserLoginMetaData loginMetaData = userLoginMetaDataRepository.findByUsernameIgnoreCase(username);
				if (loginMetaData != null)
					{
						String userId = loginMetaData.getUserId();
						String salt = loginMetaData.getSalt();
						String resolvedPassword = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password + salt);
						if (resolvedPassword.equals(loginMetaData.getPassword()))
							{
								return accessTokenService.requestToken(userId);
								
							}
						else
							{
								System.out.println("failed");
							}
					}
				return null;
			}
			
	}
