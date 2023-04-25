package com.feuji.adminservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feuji.commonmodel.UserAnswers;

public interface UserAnswersRepository extends JpaRepository<UserAnswers, Long>{
	
	List<UserAnswers> findAllByUserId(Long userId);

}
