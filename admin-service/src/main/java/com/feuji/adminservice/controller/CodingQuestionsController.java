package com.feuji.adminservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feuji.adminservice.service.CodingQuestionService;
import com.feuji.commonmodel.CodingQuestion;

@RestController
@CrossOrigin("*")
public class CodingQuestionsController {

	@Autowired
	private CodingQuestionService codingQuestionService;
	
	@PostMapping("subject/{sid}/codingquestion")
	public HttpStatus insertQuestion(@RequestBody CodingQuestion codingQuestion, @PathVariable Long sid) {
		codingQuestionService.addquestion(codingQuestion,sid);
		return HttpStatus.OK;
	}
	
	
	@GetMapping("/fetchcodingquestions")
	public List<CodingQuestion> getAllQuestions()
	{
		return codingQuestionService.getAllQuestions();
	}
	
	@GetMapping("subject/{sid}/codingquestions")
	public List<CodingQuestion> getAllCodingQuestions(@PathVariable Long sid)
	{
		return codingQuestionService.getAllCodingQuestions(sid);
	}
	
	@DeleteMapping("/deleteCodingQuestion/{id}")
	public HttpStatus deleteQuestion(@PathVariable Long id) {
		codingQuestionService.deleteQuestionById(id);
		return HttpStatus.OK;
	}
}
