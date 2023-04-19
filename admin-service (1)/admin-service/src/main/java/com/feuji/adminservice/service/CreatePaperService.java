package com.feuji.adminservice.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuji.adminservice.repo.CreatePaperRepository;
import com.feuji.adminservice.repo.QuestionRepository;
import com.feuji.commonmodel.CreatePaper;
import com.feuji.commonmodel.Question;
import com.feuji.commonmodel.Subject;

@Service
public class CreatePaperService 
{
	@Autowired
	private CreatePaperRepository createPaperRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public void addPaper(CreatePaper createPaper)
	{

		Set<Question> questionsSet=new HashSet<>();

		Arrays.asList(createPaper.getQuestionsListArray()).stream().forEach((id) -> {
											Question question =questionRepository.findById(id).get();
											questionsSet.add(question);
										});
		createPaper.setQuestions(questionsSet);
		createPaperRepository.save(createPaper);
	}
	
	public List<CreatePaper> getPaper()
	{
		return createPaperRepository.findAll();
	}
	
	public void updatePaper(CreatePaper createPaper,Long id) 
	{
	
		CreatePaper paper=createPaperRepository.findById(id).get();
		
		paper.setName(createPaper.getName());
		paper.setTotalMarks(createPaper.getTotalMarks());
		paper.setQuestions(createPaper.getQuestions());
		createPaperRepository.saveAndFlush(paper);

	}
	public Set<Question> getPaperById(CreatePaper createPaper) {
		Set<Question> set=new HashSet<>();
		CreatePaper paper= createPaperRepository.findById(createPaper.getId()).get();
		paper.getQuestions().stream().forEach(e->set.add(e));
		return set;
	}

}
