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

import com.bankingapplication.dto.TransactionDTO;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class TransactionBoundaryTest {

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
	public void testAccountNotNull() throws IOException {
		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setAccount(null);
		Set<ConstraintViolation<TransactionDTO>> violations = validator.validate(transactionDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testTransactionAmountNotNull() throws IOException {
		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setAmount(null);
		Set<ConstraintViolation<TransactionDTO>> violations = validator.validate(transactionDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testTransactionAmountPositive() throws IOException {
		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setAmount(new BigDecimal("-100.00"));
		Set<ConstraintViolation<TransactionDTO>> violations = validator.validate(transactionDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testDateNotNull() throws IOException {
		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setDate(null);
		Set<ConstraintViolation<TransactionDTO>> violations = validator.validate(transactionDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testTypeNotNull() throws IOException {
		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setType(null);
		Set<ConstraintViolation<TransactionDTO>> violations = validator.validate(transactionDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testTypeValid() throws IOException {
		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setType("INVALID");
		Set<ConstraintViolation<TransactionDTO>> violations = validator.validate(transactionDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testTypeLength() throws IOException {
		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setType("VERYLONGTYPE");
		Set<ConstraintViolation<TransactionDTO>> violations = validator.validate(transactionDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}
}
