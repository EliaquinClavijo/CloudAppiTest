package com.cloudappi.apiusers.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudappi.apiusers.models.entity.Address;

public interface AddressDao extends JpaRepository< Address, Long>{

}
