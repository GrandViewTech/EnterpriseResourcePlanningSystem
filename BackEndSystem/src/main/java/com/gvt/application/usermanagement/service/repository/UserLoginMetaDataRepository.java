package com.gvt.application.usermanagement.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gvt.application.usermanagement.entity.bo.UserLoginMetaData;

@Repository
public interface UserLoginMetaDataRepository extends CrudRepository<UserLoginMetaData, Long>
	{
		UserLoginMetaData findByUsernameIgnoreCase(String username);
	}