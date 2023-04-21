package com.feuji.adminservice.repo;

import com.feuji.commonmodel.Exam;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExamRepository extends JpaRepository<Exam, Long>{
	
	 public Exam findByCode(String code);

}
