package com.feuji.candidateservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feuji.commonmodel.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findUserByEmail(String userEmail);
}
