package com.bankingapplication.functional;

import static com.bankingapplication.utils.MasterData.getLoanDTO;
import static com.bankingapplication.utils.TestUtils.businessTestFile;
import static com.bankingapplication.utils.TestUtils.currentTest;
import static com.bankingapplication.utils.TestUtils.testReport;
import static com.bankingapplication.utils.TestUtils.yakshaAssert;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

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

import com.bankingapplication.controller.LoanController;
import com.bankingapplication.dto.LoanDTO;
import com.bankingapplication.service.LoanService;
import com.bankingapplication.utils.MasterData;

@WebMvcTest(LoanController.class)
@AutoConfigureMockMvc
public class LoanControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private LoanService loanService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testApplyForLoan() throws Exception {
		LoanDTO loanDTO = getLoanDTO();
		Long userId = 1L;

		when(this.loanService.applyForLoan(eq(userId), any())).thenReturn(loanDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/" + userId + "/loans")
				.content(MasterData.asJsonString(loanDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(loanDTO)) ? "true"
						: "false"),
				businessTestFile);
	}

	@Test
	public void testGetLoanDetailsById() throws Exception {
		LoanDTO loanDTO = getLoanDTO();
		Long userId = 1L;
		Long loanId = 1L;

		when(this.loanService.getLoanDetailsById(eq(userId), eq(loanId))).thenReturn(loanDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/" + userId + "/loans/" + loanId)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(loanDTO)) ? "true"
						: "false"),
				businessTestFile);
	}

	@Test
	public void testUpdateLoanDetailsById() throws Exception {
		LoanDTO loanDTO = getLoanDTO();
		Long userId = 1L;
		Long loanId = 1L;

		when(this.loanService.updateLoanDetailsById(eq(userId), eq(loanId), any())).thenReturn(loanDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/users/" + userId + "/loans/" + loanId)
				.content(MasterData.asJsonString(loanDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(loanDTO)) ? "true"
						: "false"),
				businessTestFile);
	}

	@Test
	public void testDeleteLoanApplicationById() throws Exception {
		Long userId = 1L;
		Long loanId = 1L;

		when(this.loanService.deleteLoanApplicationById(eq(userId), eq(loanId))).thenReturn(true);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/users/" + userId + "/loans/" + loanId)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(), (result.getResponse().getContentAsString().contentEquals("") ? "true" : "false"),
				businessTestFile);
	}

	@Test
	public void testRepayLoan() throws Exception {
		Long userId = 1L;
		Long loanId = 1L;
		BigDecimal amount = BigDecimal.valueOf(1000);

		when(this.loanService.repayLoan(eq(userId), eq(loanId), eq(amount))).thenReturn(true);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/" + userId + "/loans/" + loanId + "/repay")
				.param("amount", amount.toString()).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(), (result.getResponse().getContentAsString().contentEquals("") ? "true" : "false"),
				businessTestFile);
	}

	@Test
	public void testGetLoanStatus() throws Exception {
		Long userId = 1L;
		Long loanId = 1L;
		String status = "APPROVED";

		when(this.loanService.getLoanStatus(eq(userId), eq(loanId))).thenReturn(status);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/" + userId + "/loans/" + loanId + "/status")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(status) ? "true" : "false"), businessTestFile);
	}
}
