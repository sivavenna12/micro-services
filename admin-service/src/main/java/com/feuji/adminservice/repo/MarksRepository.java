package com.feuji.adminservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feuji.commonmodel.Marks;

public interface MarksRepository extends JpaRepository<Marks, Long>{
	
	public Marks findByUserIdAndExamId(Long userId, Long examId);
}