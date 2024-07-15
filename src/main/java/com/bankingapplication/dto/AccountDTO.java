package com.bankingapplication.dto;

import java.math.BigDecimal;
import java.util.Set;

public class AccountDTO {

	private Long id;

	private UserDTO user;

	private String accountNumber;

	private BigDecimal balance;

	private Set<TransactionDTO> transactions;

	public AccountDTO() {
		super();
	}

	public AccountDTO(Long id, UserDTO user, String accountNumber, BigDecimal balance,
			Set<TransactionDTO> transactions) {
		super();
		this.id = id;
		this.user = user;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.transactions = transactions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Set<TransactionDTO> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<TransactionDTO> transactions) {
		this.transactions = transactions;
	}
}
