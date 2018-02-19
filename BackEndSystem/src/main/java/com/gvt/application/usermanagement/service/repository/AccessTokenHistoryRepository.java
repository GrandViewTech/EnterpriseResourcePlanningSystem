package com.gvt.application.usermanagement.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gvt.application.usermanagement.entity.bo.AccessTokenHistory;

@Repository
public interface AccessTokenHistoryRepository extends CrudRepository<AccessTokenHistory, Long>
	{
		public AccessTokenHistory findByUserIdAndToken(String userId, String token);
	}
