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

import com.bankingapplication.dto.LoanDTO;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class LoanBoundaryTest {

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
	public void testLoanUserNotNull() throws IOException {
		LoanDTO loanDTO = new LoanDTO();
		loanDTO.setUser(null);
		Set<ConstraintViolation<LoanDTO>> violations = validator.validate(loanDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testLoanAmountNotNull() throws IOException {
		LoanDTO loanDTO = new LoanDTO();
		loanDTO.setAmount(null);
		Set<ConstraintViolation<LoanDTO>> violations = validator.validate(loanDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testLoanAmountPositive() throws IOException {
		LoanDTO loanDTO = new LoanDTO();
		loanDTO.setAmount(new BigDecimal("-100.00"));
		Set<ConstraintViolation<LoanDTO>> violations = validator.validate(loanDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testApplyDateNotNull() throws IOException {
		LoanDTO loanDTO = new LoanDTO();
		loanDTO.setApplyDate(null);
		Set<ConstraintViolation<LoanDTO>> violations = validator.validate(loanDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testApprovalDateNotNull() throws IOException {
		LoanDTO loanDTO = new LoanDTO();
		loanDTO.setApprovalDate(null);
		Set<ConstraintViolation<LoanDTO>> violations = validator.validate(loanDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testDisbursementDateNotNull() throws IOException {
		LoanDTO loanDTO = new LoanDTO();
		loanDTO.setDisbursementDate(null);
		Set<ConstraintViolation<LoanDTO>> violations = validator.validate(loanDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testLoanBalanceNotNull() throws IOException {
		LoanDTO loanDTO = new LoanDTO();
		loanDTO.setBalance(null);
		Set<ConstraintViolation<LoanDTO>> violations = validator.validate(loanDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testLoanBalancePositive() throws IOException {
		LoanDTO loanDTO = new LoanDTO();
		loanDTO.setBalance(new BigDecimal("-100.00"));
		Set<ConstraintViolation<LoanDTO>> violations = validator.validate(loanDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testStatusNotNull() throws IOException {
		LoanDTO loanDTO = new LoanDTO();
		loanDTO.setStatus(null);
		Set<ConstraintViolation<LoanDTO>> violations = validator.validate(loanDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testStatusValid() throws IOException {
		LoanDTO loanDTO = new LoanDTO();
		loanDTO.setStatus("INVALID");
		Set<ConstraintViolation<LoanDTO>> violations = validator.validate(loanDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testStatusLength() throws IOException {
		LoanDTO loanDTO = new LoanDTO();
		loanDTO.setStatus("THISISAVERYLONGSTATUSWHICHISINVALID");
		Set<ConstraintViolation<LoanDTO>> violations = validator.validate(loanDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}
}
