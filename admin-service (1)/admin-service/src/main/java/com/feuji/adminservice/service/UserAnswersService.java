package com.feuji.adminservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuji.adminservice.repo.UserAnswersRepository;
import com.feuji.commonmodel.UserAnswers;

@Service
public class UserAnswersService {

	@Autowired
	private UserAnswersRepository userAnswersRepository;
	
	public void saveAnswer(UserAnswers userAnswers)
	{
		userAnswersRepository.save(userAnswers);
	}
	
	public List<UserAnswers> getAnswers()
	{
		
		return userAnswersRepository.findAll();
	}
}
