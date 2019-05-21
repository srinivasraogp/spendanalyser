package com.hcl.spendanalyser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.spendanalyser.dto.MonthlyReportDTO;
import com.hcl.spendanalyser.model.Transaction;
import com.hcl.spendanalyser.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	public Transaction saveTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	public 	List<Transaction> saveTransactions(List<Transaction> transactions) {
		return transactionRepository.saveAll(transactions);
	}

	@Override
	public List<MonthlyReportDTO> getMonthlyReport(Long userId){
		return transactionRepository.getMonthlyReport(userId);
	}
}