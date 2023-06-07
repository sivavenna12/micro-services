package com.feuji.adminservice.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import com.feuji.adminservice.repo.CreatePaperRepository;
import com.feuji.adminservice.repo.ExamRepository;
import com.feuji.adminservice.repo.QuestionRepository;
import com.feuji.commonmodel.CreatePaper;
import com.feuji.commonmodel.Exam;
import com.feuji.commonmodel.Question;
import com.feuji.commonmodel.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExamService {
	@Autowired
	private ExamRepository examRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private CreatePaperRepository createPaperRepository;
	
	public void addExam(Exam exam,Long id)
	{
		CreatePaper createPaper= createPaperRepository.findById(id).get();
		exam.setCreatePaper(createPaper);
		exam.setStatus("active");
		
		examRepository.save(exam);
	}
	
	public Exam getbySid(long id)
	{
		return examRepository.findById(id).get();
	}
	public List<Exam> getAll()
	{
		return  examRepository.findByStatus("active");
	}
	public void updateExam(Exam exam,Long id) {
		Exam exam1 = examRepository.findById(id).get();
//		exam1.setCode(exam.getCode());
//		exam1.setDate(exam.getDate());
//		exam1.setMarks(exam.getMarks());
//		exam1.setName(exam.getName());
//		exam1.setQues_marks(exam.getQues_marks());
//		exam1.setTime(exam.getTime());
//		exam1.setTotal_marks(exam.getTotal_marks());
		examRepository.saveAndFlush(exam1);

	}
	public List<Subject> getSubjectsByCode(String code){
		Exam exam=examRepository.findByCode(code);
		
		List<Subject> list=new ArrayList<>();
		list.addAll(exam.getCreatePaper().getQuestions().stream().map((s)->s.getSubject()).distinct().collect(Collectors.toList())); 
		list.addAll(exam.getCreatePaper().getCodingQuestions().stream().map((s)->s.getSubject()).distinct().collect(Collectors.toList()));
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getQuestionsBySubjectId(Long sid,String code){
		Exam exam=examRepository.findByCode(code);
		
		List list=new ArrayList();
		list.addAll(exam.getCreatePaper().getQuestions().stream().filter((q)->q.getSubject().getId()==sid ).collect(Collectors.toList()));
		list.addAll(exam.getCreatePaper().getCodingQuestions().stream().filter((q)->q.getSubject().getId()==sid).collect(Collectors.toList()));
		
		return 	list;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getAllQuestionsByCode(String code){
		Exam exam=examRepository.findByCode(code);
		
		List list=new ArrayList();
		list.addAll(exam.getCreatePaper().getQuestions());
		list.addAll(exam.getCreatePaper().getCodingQuestions());
		return 	list;
	}

	public Exam getExamById(Long id) 
	{
		
		return examRepository.findById(id).get();
	}
	
	public void deletebyid(Long id)
	{
		Exam exam=examRepository.findById(id).get();
		exam.setStatus("inactive");
		examRepository.saveAndFlush(exam);
	}
//	public void deleteexamwithpaper(Long eid,Long pid)
//	{
//		Exam exam=examRepository.findById(eid).get();
//		exam.setCreatePaper(null);
//		examRepository.deleteById(eid);
//		createPaperRepository.deleteById(pid);
//	}

	public Exam getExamByCode(String code) {
		
		return examRepository.findByCode(code);
	}
	
	public List<Exam> getExamsByYear(Long year) {
		List<Exam> exams= examRepository.findAll();
		 return exams.stream().filter(e->e.getStartTime().toString().contains(year.toString())).collect(Collectors.toList());
		 
	}

}
