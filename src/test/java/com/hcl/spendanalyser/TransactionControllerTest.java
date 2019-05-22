package com.hcl.spendanalyser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.hcl.spendanalyser.dto.MonthlyReportDTO;
import com.hcl.spendanalyser.service.TransactionService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TransactionControllerTest.class, secure = false)
public class TransactionControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TransactionService transactionService;
	
	List<MonthlyReportDTO> mockData = new ArrayList<MonthlyReportDTO>(); 
	
	
	@BeforeStep
	public void addData() {
		MonthlyReportDTO data1 = new MonthlyReportDTO(111l, "march", new BigDecimal(1500));
		MonthlyReportDTO data2 = new MonthlyReportDTO(111l, "June", new BigDecimal(1500));
		MonthlyReportDTO data3 = new MonthlyReportDTO(111l, "J", new BigDecimal(1500));
		
		mockData.add(data1);
		mockData.add(data2);
		mockData.add(data3);
	}
	
	@Test
	public void retrieveDetailsForCourse() throws Exception {

		Mockito.when(
				transactionService.getMonthlyReport(Mockito.anyLong())).thenReturn(mockData);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/spendanalyser/api//spends/monthly/111").accept(
						MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println("Results========"+result.getResponse().getContentAsString());
		Assert.assertEquals(3, result.getResponse().getContentLength());
	}

}
