package com.feuji.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feuji.commonmodel.User;
import com.feuji.userservice.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/registerUser")
	public HttpStatus registerUser(@RequestBody User user) {
		userService.createUser(user);
		return HttpStatus.OK;
	}

	@PostMapping(value = "/loginUser")
	public User loginUser(@RequestBody User user) {
		return userService.userLogin(user);
	}
}
