package com.bankingapplication.boundary;

import static com.bankingapplication.utils.TestUtils.boundaryTestFile;
import static com.bankingapplication.utils.TestUtils.currentTest;
import static com.bankingapplication.utils.TestUtils.testReport;
import static com.bankingapplication.utils.TestUtils.yakshaAssert;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bankingapplication.dto.AccountDTO;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class AccountBoundaryTest {

	private static Validator validator;

	@BeforeAll
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testAccountUserNotNull() throws IOException {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setUser(null);
		Set<ConstraintViolation<AccountDTO>> violations = validator.validate(accountDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testAccountNumberNotNull() throws IOException {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountNumber(null);
		Set<ConstraintViolation<AccountDTO>> violations = validator.validate(accountDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testAccountNumberNotBlank() throws IOException {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountNumber("");
		Set<ConstraintViolation<AccountDTO>> violations = validator.validate(accountDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testAccountNumberExactLength() throws IOException {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountNumber("12345");
		Set<ConstraintViolation<AccountDTO>> violations = validator.validate(accountDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testAccountNumberNumeric() throws IOException {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountNumber("12345abcde");
		Set<ConstraintViolation<AccountDTO>> violations = validator.validate(accountDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testAccountBalanceNotNull() throws IOException {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setBalance(null);
		Set<ConstraintViolation<AccountDTO>> violations = validator.validate(accountDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testAccountBalancePositive() throws IOException {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setBalance(new BigDecimal("-100.00"));
		Set<ConstraintViolation<AccountDTO>> violations = validator.validate(accountDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}
}
