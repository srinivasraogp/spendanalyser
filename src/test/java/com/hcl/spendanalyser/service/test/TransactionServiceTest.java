package com.hcl.spendanalyser.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.spendanalyser.beans.TransactionDailyResponse;
import com.hcl.spendanalyser.dto.MonthlyReportDTO;
import com.hcl.spendanalyser.dto.WeeklyReportDTO;
import com.hcl.spendanalyser.model.Transaction;
import com.hcl.spendanalyser.repository.TransactionRepository;
import com.hcl.spendanalyser.service.TransactionServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TransactionServiceTest.class)
public class TransactionServiceTest {

	@Mock
	private TransactionRepository transactionRepository;
	
	@InjectMocks
	private TransactionServiceImpl service;
	
	@Test
	public void saveTransactionsSuccess() throws Exception {

		List<Transaction> mockData = new ArrayList<Transaction>();
		Transaction data1 = new Transaction();
		Transaction data2 = new Transaction();
		
		mockData.add(data1);
		mockData.add(data2);
		
		Mockito.when(
				transactionRepository.saveAll(Matchers.anyListOf(Transaction.class))).thenReturn(mockData);

		//test
        List<Transaction> transactionsSaved = service.saveTransactions(mockData);
         
        assertEquals(2, transactionsSaved.size());
        verify(transactionRepository, times(1)).saveAll(mockData);
        
	}
	
	@Test
	public void monthlyReportSuccess() throws Exception {

		List<MonthlyReportDTO> mockData = new ArrayList<MonthlyReportDTO>();
		MonthlyReportDTO data1 = new MonthlyReportDTO(111l, "March", new BigDecimal(1500));
		MonthlyReportDTO data2 = new MonthlyReportDTO(111l, "April", new BigDecimal(1500));
		
		mockData.add(data1);
		mockData.add(data2);
		
		Mockito.when(
				transactionRepository.getMonthlyReport(111l)).thenReturn(mockData);

		//test
        List<MonthlyReportDTO> monthlyreportResult = service.getMonthlyReport(111l);
         
        assertEquals(2, monthlyreportResult.size());
        verify(transactionRepository, times(1)).getMonthlyReport(111l);
        
	}
	
	@Test
	public void weeklyReportSuccess() throws Exception {

		List<WeeklyReportDTO> mockData = new ArrayList<WeeklyReportDTO>();
		WeeklyReportDTO data1 = new WeeklyReportDTO(222l, 1, new BigDecimal(1500));
		WeeklyReportDTO data2 = new WeeklyReportDTO(333l, 3, new BigDecimal(1500));
		
		mockData.add(data1);
		mockData.add(data2);
		
		Mockito.when(
				transactionRepository.getWeeklyReport(222l)).thenReturn(mockData);

		//test
        List<WeeklyReportDTO> weeklyreportResult = service.getWeeklyReport(222l);
         
        assertEquals(2, weeklyreportResult.size());
        verify(transactionRepository, times(1)).getWeeklyReport(222l);
        
	}
	
	@Test
	public void getUserSpendDailyTransactionsSuccess() throws Exception {

		List<TransactionDailyResponse> mockData = new ArrayList<TransactionDailyResponse>();
		TransactionDailyResponse data1 = new TransactionDailyResponse(222l, new Date(), new BigDecimal(1500));
		TransactionDailyResponse data2 = new TransactionDailyResponse(333l, new Date(), new BigDecimal(1500));
		
		mockData.add(data1);
		mockData.add(data2);
		
		Mockito.when(
				transactionRepository.getUserSpendDailyTransactions(333l)).thenReturn(mockData);

		//test
        List<TransactionDailyResponse> weeklyreportResult = service.getUserSpendDailyTransactions(333l);
         
        assertEquals(2, weeklyreportResult.size());
        verify(transactionRepository, times(1)).getUserSpendDailyTransactions(333l);
        
	}
	
}
