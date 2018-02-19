package com.gvt.application.usermanagement.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gvt.application.usermanagement.entity.bo.UserProfile;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile, Long>
	{
		public UserProfile findByUserId(String userId);
	}
