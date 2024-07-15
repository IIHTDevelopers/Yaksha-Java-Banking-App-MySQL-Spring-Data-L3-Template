package com.bankingapplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingapplication.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	// write logic for finding all accounts by user id

	// write logic for finding all accounts having balance greater than passed value
}
