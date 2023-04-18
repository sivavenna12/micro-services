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
	public boolean createUser(User user) {
		if (user != null) {
			User existUser = userRepository.findByEmail(user.getEmail());

			if (existUser != null) {
				throw new RuntimeException("User is alerdy register..");
			} else {
				userRepository.save(user);
				return true;
			}

		} else {
			return false;
		}
	}

	// login
	public User userLogin(User user) {
		System.out.print(user.getEmail() + "   " + user.getPassword());
		User userinfo = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

		if (userinfo != null) {
			return userinfo;
		} else {
			throw new RuntimeException("User Not Found!..");
		}
	}

}
