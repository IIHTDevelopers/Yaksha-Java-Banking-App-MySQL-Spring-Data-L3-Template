package com.bankingapplication.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LoanDTO {

	private Long id;

	private UserDTO user;

	private BigDecimal amount;

	private LocalDateTime applyDate;

	private LocalDateTime approvalDate;

	private LocalDateTime disbursementDate;

	private BigDecimal balance;

	private String status;

	public LoanDTO() {
		super();
	}

	public LoanDTO(Long id, UserDTO user, BigDecimal amount, LocalDateTime applyDate, LocalDateTime approvalDate,
			LocalDateTime disbursementDate, BigDecimal balance, String status) {
		super();
		this.id = id;
		this.user = user;
		this.amount = amount;
		this.applyDate = applyDate;
		this.approvalDate = approvalDate;
		this.disbursementDate = disbursementDate;
		this.balance = balance;
		this.status = status;
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(LocalDateTime applyDate) {
		this.applyDate = applyDate;
	}

	public LocalDateTime getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(LocalDateTime approvalDate) {
		this.approvalDate = approvalDate;
	}

	public LocalDateTime getDisbursementDate() {
		return disbursementDate;
	}

	public void setDisbursementDate(LocalDateTime disbursementDate) {
		this.disbursementDate = disbursementDate;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
