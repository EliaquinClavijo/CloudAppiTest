package com.cloudappi.apiusers.models.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudappi.apiusers.models.dao.AddressDao;
import com.cloudappi.apiusers.models.dao.UserDao;
import com.cloudappi.apiusers.models.entity.Address;
import com.cloudappi.apiusers.models.entity.User;
import com.cloudappi.apiusers.models.iservice.IUserService;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AddressDao addressDao;

	@Override
	public List<User> GetUsers() {
		return (List<User>) userDao.findAll();
	}

	@Override
	public User CreateUser(@Valid User newUser) {
		newUser.setId(null);
		Long entranceId = newUser.getAddress().getId();
		Address address = (addressDao.findById(entranceId).orElse(null)) == null  ? addressDao.save(newUser.getAddress()) :newUser.getAddress();
		return userDao.save(newUser);
	}

	@Override
	public User GetUsersById(Long userId) {
		return userDao.findById(userId).orElseThrow(() -> new EntityNotFoundException(
				"User not found"));
	}

	@Override
	public User UpdateUsersById(Long userId, @Valid User user) {
		userDao.findById(userId).orElseThrow(() -> new EntityNotFoundException(
				"User not found"));
		user.setId(userId);
		return userDao.save(user);
	}

	@Override
	public void DeleteUsersById(Long userId) {
		User userInDb = userDao.findById(userId).orElseThrow(() -> new EntityNotFoundException(
				"User not found"));
		userDao.delete(userInDb);
	}
}
