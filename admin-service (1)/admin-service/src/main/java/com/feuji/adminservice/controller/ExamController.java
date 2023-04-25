package com.feuji.adminservice.controller;

import com.feuji.adminservice.service.ExamService;
import com.feuji.commonmodel.Exam;
import com.feuji.commonmodel.Question;
import com.feuji.commonmodel.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
public class ExamController {
	@Autowired
	private ExamService examService;
	
	@PostMapping("/addexam/{pid}")
	public HttpStatus addexam(@RequestBody Exam exam,@PathVariable Long pid)
	{
		examService.addExam(exam,pid);
		return HttpStatus.OK;
	}
	
	@PutMapping("/updateexam/{id}")
	public void update(@RequestBody Exam exam ,@PathVariable Long id)
	{
		examService.updateExam(exam,id);
	}
	
	@GetMapping("/getallexams")
	public List<Exam> getAllExams(){
		return examService.getAll();
	}
	
	@GetMapping("/getquestions/{sid}")
	public  Exam get(@PathVariable Long sid)
	{
		return  examService.getbySid(sid);
	}
	@PostMapping("/getsubjectsBycode/{code}")
	public Set<Subject> getSubjectsByCode(@PathVariable String code){
		System.out.println(code);
		return examService.getSubjectsByCode(code);
		
	}
	
	@GetMapping("/getquestionsBySubjectId/{sid}/{code}")
	public Set<Question> getQuestionsBySubjectId(@PathVariable Long sid ,@PathVariable String code){
		System.out.println(code);
		return examService.getQuestionsBySubjectId(sid,code);
		
	}
}
