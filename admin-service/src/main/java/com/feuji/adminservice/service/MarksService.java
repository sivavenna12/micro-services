package com.feuji.adminservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuji.adminservice.repo.ExamRepository;
import com.feuji.adminservice.repo.MarksRepository;
import com.feuji.commonmodel.CreatePaper;
import com.feuji.commonmodel.Exam;
import com.feuji.commonmodel.Marks;

@Service
public class MarksService {
	
	@Autowired
	private ExamRepository examRepository;
	@Autowired
	private MarksRepository marksRepository;

	public void addMarks(Marks marks) {
		Marks existingMarks = marksRepository.findByUserIdAndExamId(marks.getUser().getId(), marks.getExam().getId());
		if(existingMarks == null) {
			Exam exam=examRepository.findById(marks.getExam().getId()).get();
			marks.setTotalMarks(exam.getCreatePaper().getTotalMarks());
			marksRepository.save(marks);
		}
	}

	
	public List<Marks> getMarks() {
		return marksRepository.findAll();
	}

	public boolean isUserWrittenExam(Long userId, Long examId) {

		Marks marks = marksRepository.findByUserIdAndExamId(userId, examId);
		if (marks == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public  List<Marks> getMarksByUserId(Long userId) {
		return marksRepository.findByUserId(userId);
	}

}