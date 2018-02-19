package com.gvt.application.usermanagement.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gvt.application.usermanagement.entity.bo.AccessToken;

@Repository
public interface AccessTokenRepository extends CrudRepository<AccessToken, Long>
	{
		AccessToken findByUserId(String userid);
	}
