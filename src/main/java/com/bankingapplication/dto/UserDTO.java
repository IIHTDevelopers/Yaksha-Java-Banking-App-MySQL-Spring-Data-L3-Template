package com.bankingapplication.dto;

import java.util.Set;

public class UserDTO {

	private Long id;

	private String name;

	private String email;

	private String password;

	private Set<AccountDTO> accounts;

	private Set<LoanDTO> loans;

	public UserDTO() {
		super();
	}

	public UserDTO(Long id, String name, String email, String password, Set<AccountDTO> accounts, Set<LoanDTO> loans) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.accounts = accounts;
		this.loans = loans;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<AccountDTO> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<AccountDTO> accounts) {
		this.accounts = accounts;
	}

	public Set<LoanDTO> getLoans() {
		return loans;
	}

	public void setLoans(Set<LoanDTO> loans) {
		this.loans = loans;
	}
}
