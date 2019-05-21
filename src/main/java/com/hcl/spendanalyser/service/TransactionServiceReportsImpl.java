package com.hcl.spendanalyser.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.spendanalyser.beans.TransactionDailyResponse;
import com.hcl.spendanalyser.model.Transaction;
import com.hcl.spendanalyser.repository.*;

@Service
public class TransactionServiceReportsImpl implements  TransactionServiceReports {
	
	@Autowired
	TransactionRepository transRepo;

	@Override
	public List<TransactionDailyResponse> getUserSpendDailyTransactions(Long userId) {
		
		List list = new ArrayList<TransactionDailyResponse>();
		list =  transRepo.getUserSpendDailyTransactions(userId);
		return list;
		// TODO Auto-generated method stub
		
	}
	


}
