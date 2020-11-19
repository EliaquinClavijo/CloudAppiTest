package com.cloudappi.apiusers.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudappi.apiusers.models.entity.User;
import com.cloudappi.apiusers.models.iservice.IUserService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("getUsers")
	@Operation(summary = "Get all users")
	public List<User> GetUsers() {
		return userService.GetUsers();
	}
	
	@PostMapping("createUsers")
	public User CreateUser(@RequestBody @Valid User newUser) {
		return userService.CreateUser(newUser);
	}
	
	@GetMapping("getUsersById/{userId}")
	@Operation(summary = "Get one user")
	public User GetUsersById(@PathVariable Long userId) {
		return userService.GetUsersById(userId);
	}

	@PutMapping("updateUsersById/{userId}")
	public User UpdateUsersById(@PathVariable Long userId, @RequestBody @Valid User User) {
		return userService.UpdateUsersById(userId, User);
	}
	
	@DeleteMapping("deleteUsersById/{userId}")
	public void DeleteUsersById(@PathVariable Long userId) {
		userService.DeleteUsersById(userId);
	}
}
