package com.bankingapplication.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bankingapplication.dto.LoanDTO;
import com.bankingapplication.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

	@Override
	public LoanDTO applyForLoan(Long userId, LoanDTO loanDTO) {
		// write your logic here
		return null;
	}

	@Override
	public LoanDTO getLoanDetailsById(Long userId, Long loanId) {
		// write your logic here
		return null;
	}

	@Override
	public LoanDTO updateLoanDetailsById(Long userId, Long loanId, LoanDTO loanDTO) {
		// write your logic here
		return null;
	}

	@Override
	public Boolean deleteLoanApplicationById(Long userId, Long loanId) {
		// write your logic here
		return null;
	}

	@Override
	public List<LoanDTO> getLoansByUserId(Long userId) {
		// write your logic here
		return null;
	}

	@Override
	public Boolean repayLoan(Long userId, Long loanId, BigDecimal amount) {
		// write your logic here
		return null;
	}

	@Override
	public String getLoanStatus(Long userId, Long loanId) {
		// write your logic here
		return null;
	}
}
