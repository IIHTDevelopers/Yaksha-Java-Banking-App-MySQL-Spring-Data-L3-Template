package com.bankingapplication.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDTO {

	private Long id;

	private AccountDTO account;

	private BigDecimal amount;

	private LocalDateTime date;

	private String type;

	public TransactionDTO() {
		super();
	}

	public TransactionDTO(Long id, AccountDTO account, BigDecimal amount, LocalDateTime date, String type) {
		super();
		this.id = id;
		this.account = account;
		this.amount = amount;
		this.date = date;
		this.type = type;
	}

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AccountDTO getAccount() {
		return account;
	}

	public void setAccount(AccountDTO account) {
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
