package com.bankingapplication.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bankingapplication.dto.TransactionDTO;
import com.bankingapplication.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Override
	public TransactionDTO addTransaction(Long userId, String accountId, TransactionDTO transactionDTO) {
		// write your logic here
		return null;
	}

	@Override
	public List<TransactionDTO> getAllTransactionsForUser(Long userId, int page, int size) {
		// write your logic here
		return null;
	}

	@Override
	public List<TransactionDTO> getUserTransactionsWithDateRange(Long userId, LocalDateTime startDate,
			LocalDateTime endDate) {
		// write your logic here
		return null;
	}

	@Override
	public List<TransactionDTO> getUserTransactionsWithAmountRange(Long userId, BigDecimal minAmount,
			BigDecimal maxAmount) {
		// write your logic here
		return null;
	}
}
