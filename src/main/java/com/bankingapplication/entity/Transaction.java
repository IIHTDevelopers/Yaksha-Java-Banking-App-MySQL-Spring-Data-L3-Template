package com.bankingapplication.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

	private Long id;

	private Account account;

	private BigDecimal amount;

	private LocalDateTime date;

	private String type;

	public Transaction() {
		super();
	}

	public Transaction(Long id, Account account, BigDecimal amount, LocalDateTime date, String type) {
		super();
		this.id = id;
		this.account = account;
		this.amount = amount;
		this.date = date;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
