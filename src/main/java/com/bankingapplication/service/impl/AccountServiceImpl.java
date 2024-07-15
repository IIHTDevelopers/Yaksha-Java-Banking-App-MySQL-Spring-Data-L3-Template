package com.bankingapplication.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bankingapplication.dto.AccountDTO;
import com.bankingapplication.dto.TransactionDTO;
import com.bankingapplication.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Override
	public AccountDTO createAccount(Long userId, AccountDTO accountDTO) {
		// write your logic here
		return null;
	}

	@Override
	public AccountDTO getAccountById(Long userId, Long accountId) {
		// write your logic here
		return null;
	}

	@Override
	public AccountDTO updateAccountById(Long userId, Long accountId, AccountDTO accountDTO) {
		// write your logic here
		return null;
	}

	@Override
	public Boolean deleteAccountById(Long userId, Long accountId) {
		// write your logic here
		return null;
	}

	@Override
	public List<AccountDTO> getAccountsByUserId(Long userId) {
		// write your logic here
		return null;
	}

	@Override
	public BigDecimal getAccountBalance(Long userId, Long accountId) {
		// write your logic here
		return null;
	}

	@Override
	public Boolean transferFunds(Long userId, Long fromAccountId, Long toAccountId, BigDecimal amount) {
		// write your logic here
		return null;
	}

	@Override
	public List<TransactionDTO> getAccountStatements(Long userId, Long accountId, LocalDateTime startDate,
			LocalDateTime endDate) {
		// write your logic here
		return null;
	}
}
