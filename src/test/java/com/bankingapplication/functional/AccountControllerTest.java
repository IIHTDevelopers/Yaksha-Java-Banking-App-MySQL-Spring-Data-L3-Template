package com.bankingapplication.functional;

import static com.bankingapplication.utils.MasterData.getAccountDTO;
import static com.bankingapplication.utils.MasterData.getTransactionDTOList;
import static com.bankingapplication.utils.TestUtils.businessTestFile;
import static com.bankingapplication.utils.TestUtils.currentTest;
import static com.bankingapplication.utils.TestUtils.testReport;
import static com.bankingapplication.utils.TestUtils.yakshaAssert;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bankingapplication.controller.AccountController;
import com.bankingapplication.dto.AccountDTO;
import com.bankingapplication.dto.TransactionDTO;
import com.bankingapplication.service.AccountService;
import com.bankingapplication.utils.MasterData;

@WebMvcTest(AccountController.class)
@AutoConfigureMockMvc
public class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccountService accountService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testCreateAccount() throws Exception {
		AccountDTO accountDTO = getAccountDTO();
		Long userId = 1L;

		when(this.accountService.createAccount(eq(userId), any())).thenReturn(accountDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/" + userId + "/accounts")
				.content(MasterData.asJsonString(accountDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(accountDTO)) ? "true"
						: "false"),
				businessTestFile);
	}

	@Test
	public void testGetAccountById() throws Exception {
		AccountDTO accountDTO = getAccountDTO();
		Long userId = 1L;
		Long accountId = 1L;

		when(this.accountService.getAccountById(eq(userId), eq(accountId))).thenReturn(accountDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/" + userId + "/accounts/" + accountId)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(accountDTO)) ? "true"
						: "false"),
				businessTestFile);
	}

	@Test
	public void testUpdateAccountById() throws Exception {
		AccountDTO accountDTO = getAccountDTO();
		Long userId = 1L;
		Long accountId = 1L;

		when(this.accountService.updateAccountById(eq(userId), eq(accountId), any())).thenReturn(accountDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/users/" + userId + "/accounts/" + accountId)
				.content(MasterData.asJsonString(accountDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(accountDTO)) ? "true"
						: "false"),
				businessTestFile);
	}

	@Test
	public void testDeleteAccountById() throws Exception {
		Long userId = 1L;
		Long accountId = 1L;

		when(this.accountService.deleteAccountById(eq(userId), eq(accountId))).thenReturn(true);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/users/" + userId + "/accounts/" + accountId)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(), (result.getResponse().getContentAsString().contentEquals("") ? "true" : "false"),
				businessTestFile);
	}

	@Test
	public void testGetAccountBalance() throws Exception {
		Long userId = 1L;
		Long accountId = 1L;
		BigDecimal balance = BigDecimal.valueOf(1000);

		when(this.accountService.getAccountBalance(eq(userId), eq(accountId))).thenReturn(balance);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/users/" + userId + "/accounts/" + accountId + "/balance").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(balance.toString()) ? "true" : "false"),
				businessTestFile);
	}

	@Test
	public void testTransferFunds() throws Exception {
		Long userId = 1L;
		Long fromAccountId = 1L;
		Long toAccountId = 2L;
		BigDecimal amount = BigDecimal.valueOf(500);

		when(this.accountService.transferFunds(eq(userId), eq(fromAccountId), eq(toAccountId), eq(amount)))
				.thenReturn(true);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/" + userId + "/accounts/transfer")
				.param("fromAccountId", fromAccountId.toString()).param("toAccountId", toAccountId.toString())
				.param("amount", amount.toString()).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(), (result.getResponse().getContentAsString().contentEquals("") ? "true" : "false"),
				businessTestFile);
	}

	@Test
	public void testGetAccountStatements() throws Exception {
		Long userId = 1L;
		Long accountId = 1L;
		LocalDateTime startDate = LocalDateTime.now().minusDays(30);
		LocalDateTime endDate = LocalDateTime.now();
		List<TransactionDTO> transactionDTOList = getTransactionDTOList();

		when(this.accountService.getAccountStatements(eq(userId), eq(accountId), eq(startDate), eq(endDate)))
				.thenReturn(transactionDTOList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/users/" + userId + "/accounts/" + accountId + "/statements")
				.param("startDate", startDate.toString()).param("endDate", endDate.toString())
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(transactionDTOList))
						? "true"
						: "false"),
				businessTestFile);
	}
}
