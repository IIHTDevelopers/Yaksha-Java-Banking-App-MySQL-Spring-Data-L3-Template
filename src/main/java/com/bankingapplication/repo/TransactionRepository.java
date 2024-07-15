package com.bankingapplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingapplication.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	// write logic for finding all transactions in Page by user id

	// write logic for finding all transactions for account having passed user id
	// and is in between passed dates

	// write logic for finding all transactions for account having passed user id
	// and between passed amount
}
