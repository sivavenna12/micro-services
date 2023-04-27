package com.feuji.adminservice.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feuji.commonmodel.CodingQuestion;

public interface CodingQuestionRepository extends JpaRepository<CodingQuestion, Long> {
	
	public  Set<CodingQuestion> findBySubjectId(Long subjectId);

}
