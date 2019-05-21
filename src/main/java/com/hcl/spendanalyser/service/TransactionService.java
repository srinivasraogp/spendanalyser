package com.hcl.spendanalyser.service;

import java.util.List;

import com.hcl.spendanalyser.dto.MonthlyReportDTO;
import com.hcl.spendanalyser.model.Transaction;

public interface TransactionService {

	Transaction saveTransaction(Transaction transaction);
	
	List<Transaction> saveTransactions(List<Transaction> transactions);
	
	List<MonthlyReportDTO> getMonthlyReport(Long userId);
}
