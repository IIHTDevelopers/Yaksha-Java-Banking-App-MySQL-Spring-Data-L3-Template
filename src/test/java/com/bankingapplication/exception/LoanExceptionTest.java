package com.bankingapplication.exception;

import static com.bankingapplication.utils.TestUtils.currentTest;
import static com.bankingapplication.utils.TestUtils.exceptionTestFile;
import static com.bankingapplication.utils.TestUtils.testReport;
import static com.bankingapplication.utils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
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
public class LoanExceptionTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private LoanService loanService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testGetLoanDetailsByIdNotFoundException() throws Exception {
		Long userId = 1L;
		Long loanId = 1L;
		ErrorResponse exResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Loan not found");

		when(loanService.getLoanDetailsById(userId, loanId)).thenThrow(new NotFoundException("Loan not found"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/" + userId + "/loans/" + loanId)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contains(exResponse.getMessage()) ? "true" : "false"),
				exceptionTestFile);
	}

	@Test
	public void testDeleteLoanApplicationByIdNotFoundException() throws Exception {
		Long userId = 1L;
		Long loanId = 1L;
		ErrorResponse exResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Loan not found");

		when(loanService.deleteLoanApplicationById(userId, loanId)).thenThrow(new NotFoundException("Loan not found"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/users/" + userId + "/loans/" + loanId)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contains(exResponse.getMessage()) ? "true" : "false"),
				exceptionTestFile);
	}

	@Test
	public void testRepayLoanNotFoundException() throws Exception {
		Long userId = 1L;
		Long loanId = 1L;
		BigDecimal amount = new BigDecimal("1000.00");
		ErrorResponse exResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Loan not found");

		when(loanService.repayLoan(userId, loanId, amount)).thenThrow(new NotFoundException("Loan not found"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/" + userId + "/loans/" + loanId + "/repay")
				.param("amount", amount.toString()).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contains(exResponse.getMessage()) ? "true" : "false"),
				exceptionTestFile);
	}

	@Test
	public void testGetLoanStatusNotFoundException() throws Exception {
		Long userId = 1L;
		Long loanId = 1L;
		ErrorResponse exResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Loan not found");

		when(loanService.getLoanStatus(userId, loanId)).thenThrow(new NotFoundException("Loan not found"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/" + userId + "/loans/" + loanId + "/status")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contains(exResponse.getMessage()) ? "true" : "false"),
				exceptionTestFile);
	}

	@Test
	public void testApplyForLoanInvalidDataException() throws Exception {
		Long userId = 1L;
		LoanDTO loanDTO = new LoanDTO(); // Create an invalid LoanDTO

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/" + userId + "/loans")
				.content(MasterData.asJsonString(loanDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);
	}

	@Test
	public void testUpdateLoanDetailsByIdInvalidDataException() throws Exception {
		Long userId = 1L;
		Long loanId = 1L;
		LoanDTO loanDTO = new LoanDTO(); // Create an invalid LoanDTO

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/users/" + userId + "/loans/" + loanId)
				.content(MasterData.asJsonString(loanDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);
	}
}
