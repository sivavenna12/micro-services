package com.feuji.userservice.service;

import com.feuji.commonmodel.User;
import com.feuji.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	// register
	public User createUser(User user) {
		if (user != null) {
			User existUser = userRepository.findByEmail(user.getEmail());

			if (existUser != null) {
				return null;
			} else {
				
				return userRepository.save(user);
			}

		} else {
			return null;
		}
	}

	// login
	public User userLogin(User user) {
		System.out.print(user.getEmail() + "   " + user.getPassword());
		User userinfo = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

		if (userinfo != null) {
			return userinfo;
		} else {
			return null;
		}
	}
	//update
	public boolean editUser(User user) {
		  User editUser=userRepository.findByEmail(user.getEmail());
		  if(editUser!=null) {
		 editUser.setPassword(user.getPassword());
		 userRepository.saveAndFlush(editUser);
		 return true;
		  }
		  return false;
	  }

}
