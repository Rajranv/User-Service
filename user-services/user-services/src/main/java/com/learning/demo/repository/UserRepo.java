package com.learning.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.demo.entity.User;

public interface UserRepo extends JpaRepository<User,Long> {

	Optional<User> findByUserId(Long userId);

}
