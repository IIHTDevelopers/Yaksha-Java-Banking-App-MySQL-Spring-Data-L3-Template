package com.bankingapplication.entity;

import java.math.BigDecimal;
import java.util.Set;

public class Account {

	private Long id;

	private User user;

	private String accountNumber;

	private BigDecimal balance;

	private Set<Transaction> transactions;

	public Account() {
		super();
	}

	public Account(Long id, User user, String accountNumber, BigDecimal balance, Set<Transaction> transactions) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
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

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
}
