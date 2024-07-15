package com.bankingapplication.functional;

import static com.bankingapplication.utils.MasterData.getTransactionDTO;
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

import com.bankingapplication.controller.TransactionController;
import com.bankingapplication.dto.TransactionDTO;
import com.bankingapplication.service.TransactionService;
import com.bankingapplication.utils.MasterData;

@WebMvcTest(TransactionController.class)
@AutoConfigureMockMvc
public class TransactionControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TransactionService transactionService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testAddTransaction() throws Exception {
		TransactionDTO transactionDTO = getTransactionDTO();
		Long userId = 1L;
		String accountId = "12345";

		when(this.transactionService.addTransaction(eq(userId), eq(accountId), any())).thenReturn(transactionDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/users/" + userId + "/accounts/" + accountId + "/transactions")
				.content(MasterData.asJsonString(transactionDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(transactionDTO))
						? "true"
						: "false"),
				businessTestFile);
	}
}
