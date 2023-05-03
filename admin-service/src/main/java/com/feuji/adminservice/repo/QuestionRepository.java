package com.feuji.adminservice.repo;

import java.util.Set;

import com.feuji.commonmodel.Question;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionRepository extends JpaRepository<Question, Long>{

	public  Set<Question> findBySubjectIdAndStatus(Long subjectId,String status);
	
	
	/* public Set<Question> findByExamId(Long examId); */
	
}
