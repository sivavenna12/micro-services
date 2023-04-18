package com.feuji.adminservice.service;

import java.util.Set;

import com.feuji.adminservice.repo.QuestionRepository;
import com.feuji.adminservice.repo.SubjectRepository;
import com.feuji.commonmodel.Question;
import com.feuji.commonmodel.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	public Question addquestion(Question question, Long id)
    {
    	Subject subject=subjectRepository.findById(id).get();
    	question.setSubject(subject);
    	return questionRepository.save(question);
    }
	public Set<Question> getAllQuestions(Long id) {
		Set<Question> set = questionRepository.findBySubjectId(id);
		return set;
	}
	
	public void updatequestions(Question question,Long id)
    {
    	Question question1=questionRepository.findById(id).get();
    	question1.setContent(question.getContent());
    	question1.setOption_A(question.getOption_A());
    	question1.setOption_B(question.getOption_B());
    	question1.setOption_C(question.getOption_C());
    	question1.setOption_D(question.getOption_D());
    	question1.setAnswer(question.getAnswer());
    	question1.setQ_type(question.getQ_type());
    	questionRepository.saveAndFlush(question1);
    }

}
