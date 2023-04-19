package com.feuji.candidateservice.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.feuji.candidateservice.repo.UserRepository;
import com.feuji.commonmodel.User;

public class CandidateService {

	@Autowired
	private UserRepository userRepository;

	public User getUserProfile(String candidateEmail) {
		return userRepository.findUserByEmail(candidateEmail);
	}
}
