package com.cloudappi.apiusers.models.iservice;

import java.util.List;

import javax.validation.Valid;

import com.cloudappi.apiusers.models.entity.User;

public interface IUserService {

	public List<User> GetUsers();

	public User CreateUser(User newUser);

	public User GetUsersById(Long userId);

	public User UpdateUsersById(Long userId, @Valid User user);

	public void DeleteUsersById(Long userId);

}
