package com.bankingapplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingapplication.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	// write logic for finding all users by name

	// write logic for finding all users by email
}
