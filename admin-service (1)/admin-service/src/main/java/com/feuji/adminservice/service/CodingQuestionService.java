package com.feuji.adminservice.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuji.adminservice.repo.CodingQuestionRepository;
import com.feuji.adminservice.repo.SubjectRepository;
import com.feuji.commonmodel.CodingQuestion;
import com.feuji.commonmodel.Subject;

@Service
public class CodingQuestionService 
{
	@Autowired
	private CodingQuestionRepository codingQuestionRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	public void addquestion(CodingQuestion codingQuestion, Long sid) {
		
		Subject subject = subjectRepository.findById(sid).get();
		codingQuestion.setSubject(subject);
		codingQuestionRepository.save(codingQuestion);
	}
	
	public Set<CodingQuestion> getAllQuestions(Long id) {
		Set<CodingQuestion> set = codingQuestionRepository.findBySubjectId(id);
		return set;
	}

}
