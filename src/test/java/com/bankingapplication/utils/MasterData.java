package com.bankingapplication.utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bankingapplication.dto.AccountDTO;
import com.bankingapplication.dto.LoanDTO;
import com.bankingapplication.dto.TransactionDTO;
import com.bankingapplication.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class MasterData {

	public static UserDTO getUserDTO() {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(1L);
		userDTO.setName("John Doe");
		userDTO.setEmail("john.doe@example.com");
		userDTO.setPassword("password123");
		return userDTO;
	}

	public static List<UserDTO> getUserDTOList() {
		List<UserDTO> userDTOList = new ArrayList<>();
		userDTOList.add(getUserDTO());
		return userDTOList;
	}

	public static AccountDTO getAccountDTO() {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId(1L);
		accountDTO.setAccountNumber("1234567890");
		accountDTO.setBalance(new BigDecimal("1000.00"));
		accountDTO.setUser(getUserDTO());
		return accountDTO;
	}

	public static Set<AccountDTO> getAccountDTOSet() {
		Set<AccountDTO> accountDTOSet = new HashSet<>();
		accountDTOSet.add(getAccountDTO());
		return accountDTOSet;
	}

	public static LoanDTO getLoanDTO() {
		LoanDTO loanDTO = new LoanDTO();
		loanDTO.setId(1L);
		loanDTO.setAmount(new BigDecimal("5000.00"));
		loanDTO.setApplyDate(LocalDateTime.of(2023, 1, 14, 15, 30));
		loanDTO.setApprovalDate(LocalDateTime.of(2023, 1, 15, 15, 30));
		loanDTO.setDisbursementDate(LocalDateTime.of(2023, 1, 16, 15, 30));
		loanDTO.setBalance(new BigDecimal("5000.00"));
		loanDTO.setStatus("APPROVED");
		loanDTO.setUser(getUserDTO());
		return loanDTO;
	}

	public static Set<LoanDTO> getLoanDTOSet() {
		Set<LoanDTO> loanDTOSet = new HashSet<>();
		loanDTOSet.add(getLoanDTO());
		return loanDTOSet;
	}

	public static TransactionDTO getTransactionDTO() {
		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setId(1L);
		transactionDTO.setAmount(new BigDecimal("500.00"));
		transactionDTO.setDate(LocalDateTime.of(2023, 1, 14, 15, 30));
		transactionDTO.setType("DEBIT");
		transactionDTO.setAccount(getAccountDTO());
		return transactionDTO;
	}

	public static List<TransactionDTO> getTransactionDTOList() {
		List<TransactionDTO> transactionDTOList = new ArrayList<>();
		transactionDTOList.add(getTransactionDTO());
		return transactionDTOList;
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String randomStringWithSize(int size) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < size; i++) {
			s.append("A");
		}
		return s.toString();
	}
}
