package com.feuji.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feuji.commonmodel.Role;
import com.feuji.commonmodel.User;
import com.feuji.userservice.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/registerUser")
	public User registerUser(@RequestBody User user) {
		 if(user.getRole()==null) {
		    	user.setRole(Role.USER);
		    }
		       
		return userService.createUser(user);
	}

	@PostMapping(value = "/loginUser")
	public User loginUser(@RequestBody User user) {
		return userService.userLogin(user);
	}
	@PutMapping(value="/forgotpassword")
	public void forgotPassword(@RequestBody User user ) {
			
	userService.editUser(user);
	}
	@PostMapping(value = "/getUserById")
	public User getUserById(@RequestBody User user) {
		return userService.getUserById(user);	
	}
}
