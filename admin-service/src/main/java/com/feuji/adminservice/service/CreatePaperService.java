package com.feuji.adminservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuji.adminservice.repo.CodingQuestionRepository;
import com.feuji.adminservice.repo.CreatePaperRepository;
import com.feuji.adminservice.repo.QuestionRepository;
import com.feuji.commonmodel.CodingQuestion;
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
	
	@Autowired
	private CodingQuestionRepository codingQuestionRepository;
	
	public void addPaper(CreatePaper createPaper)
	{
		createPaper.setStatus("active");

		List<Question> questionsList=new ArrayList<>();
		
		List<CodingQuestion> codingQuestionsList=new ArrayList<>();

		if(createPaper.getQuestionsListArray()!=null) {
			
			Arrays.asList(createPaper.getQuestionsListArray()).stream().forEach((id) -> {
				Question question =questionRepository.findById(id).get();
				questionsList.add(question);
			});
			createPaper.setQuestions(questionsList);
			
		}
		
		if(createPaper.getCodingQuestionsListArray()!=null) {
			
			Arrays.asList(createPaper.getCodingQuestionsListArray()).stream().forEach((id) -> {
				CodingQuestion codingQuestion =codingQuestionRepository.findById(id).get();
				codingQuestionsList.add(codingQuestion);
			});
			createPaper.setCodingQuestions(codingQuestionsList);
		}
		
		createPaperRepository.save(createPaper);
	}
	
	
	
	public List<CreatePaper> getPaper()
	{
		return createPaperRepository.findByStatus("active");
	}
	
	public void updatePaper(CreatePaper createPaper,Long id) 
	{
	
		CreatePaper paper=createPaperRepository.findById(id).get();
		
		paper.setName(createPaper.getName());
		paper.setTotalMarks(createPaper.getTotalMarks());
		paper.setQuestions(createPaper.getQuestions());
		createPaperRepository.saveAndFlush(paper);

	}
	
	public List<Subject> getSubjectsByPaperId(Long pid)
	{
		CreatePaper paper= createPaperRepository.findById(pid).get();
		List<Subject> list=new ArrayList<>();
		list.addAll(paper.getQuestions().stream().map((s)->s.getSubject()).collect(Collectors.toList())); 
		list.addAll(paper.getCodingQuestions().stream().map((s)->s.getSubject()).collect(Collectors.toList()));
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getPaperById(CreatePaper createPaper) {
		List list=new ArrayList();
		CreatePaper paper= createPaperRepository.findById(createPaper.getId()).get();
		paper.getQuestions().stream().forEach(e->list.add(e));
		paper.getCodingQuestions().stream().forEach(e->list.add(e));
		return list;
	}
	
	public void deletebyid(Long id)
	{
		CreatePaper paper= createPaperRepository.findById(id).get();
		paper.setStatus("inactive");
		createPaperRepository.saveAndFlush(paper);
	}

}
