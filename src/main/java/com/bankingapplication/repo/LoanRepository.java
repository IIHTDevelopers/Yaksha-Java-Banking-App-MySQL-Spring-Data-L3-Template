package com.bankingapplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingapplication.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

	// write logic for finding all loans by user id

	// write logic for finding all loans by status
}
