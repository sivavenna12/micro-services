package com.feuji.candidateservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.feuji.candidateservice.repo.CandidateRepository;
import com.feuji.commonmodel.User;
import com.feuji.commonmodel.UserAnswers;

@Service
public class CandidateService {

	@Autowired
	private   CandidateRepository candidateRepository;

	public String correctAnswer;

	private RestTemplate restTemplate;
	
	public CandidateService(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}
	
	//Product product = restTemplate.getForObject(sellerserviceUrl+"/findproductbyid?productId="+productId, Product.class);

	Long score=(long) 0;
	public Long getuserScore()
	{

		UserAnswers[] userAnswers =restTemplate.getForObject("http://localhost:8089/api/getanswers/2",UserAnswers[].class);
		
		for(UserAnswers answers:userAnswers) 
		{
			//answers.getExam().getCreatePaper().getQuestions().stream().forEach((q)->{correctAnswer=q.getAnswer();});
			
			if(answers.getUserAnswer().equals(answers.getQuestion().getAnswer()) && answers.getExam().getId()==10)
			{
				score++;
			}
		}
		
		return score;
	}
}

