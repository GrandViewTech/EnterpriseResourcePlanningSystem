package com.gvt.application.usermanagement.service.business.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gvt.application.usermanagement.entity.bo.AccessToken;
import com.gvt.application.usermanagement.entity.bo.AccessTokenHistory;
import com.gvt.application.usermanagement.service.business.AccessTokenService;
import com.gvt.application.usermanagement.service.plugin.TokenPlugin;
import com.gvt.application.usermanagement.service.repository.AccessTokenHistoryRepository;
import com.gvt.application.usermanagement.service.repository.AccessTokenRepository;

@Service
public class AccessTokenServiceImpl implements AccessTokenService
	{
		@Autowired
		private AccessTokenRepository			accessTokenRepository;
		
		@Autowired
		private AccessTokenHistoryRepository	accessTokenHistoryRepository;
		
		@Override
		@Transactional(propagation = Propagation.MANDATORY)
		public String requestToken(String userId)
			{
				AccessToken accessToken = accessTokenRepository.findByUserId(userId);
				if (accessToken != null)
					{
						accessTokenRepository.delete(accessToken);
						AccessTokenHistory history = accessTokenHistoryRepository.findByUserIdAndToken(userId, accessToken.getToken());
						accessTokenHistoryRepository.save(history.update(System.currentTimeMillis()));
					}
				// UPDATING ACCESS TOKEN HISTORY
				String validToken = TokenPlugin.requestToken(userId);
				AccessToken newToken = new AccessToken(userId, validToken, 60);
				newToken = accessTokenRepository.save(newToken);
				accessTokenHistoryRepository.save(new AccessTokenHistory(userId, validToken, newToken.getCreatedOn()));
				return newToken.getToken();
			}
			
	}
