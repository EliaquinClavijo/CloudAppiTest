package com.cloudappi.apiusers.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudappi.apiusers.models.entity.User;

public interface UserDao extends JpaRepository< User, Long>{

}
