package com.gvt.application.usermanagement.service.plugin;

import java.util.UUID;

public class TokenPlugin
	{
		public static String requestToken(String userId)
			{
				return org.apache.commons.codec.digest.DigestUtils.sha256Hex((userId + UUID.randomUUID() + System.currentTimeMillis()));
			}
			
	}
