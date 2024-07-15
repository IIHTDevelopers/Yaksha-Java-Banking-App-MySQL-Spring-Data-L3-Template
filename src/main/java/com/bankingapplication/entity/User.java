package com.bankingapplication.entity;

import java.util.Set;

public class User {
	
	private Long id;

	private String name;

	private String email;

	private String password;

	private Set<Account> accounts;

	private Set<Loan> loans;

	public User() {
		super();
	}

	public User(Long id, String name, String email, String password, Set<Account> accounts, Set<Loan> loans) {
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

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public Set<Loan> getLoans() {
		return loans;
	}

	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}
}
