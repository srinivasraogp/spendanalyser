package com.hcl.spendanalyser.service;

import java.util.List;

import com.hcl.spendanalyser.beans.TransactionDailyResponse;
import com.hcl.spendanalyser.model.Transaction;

public interface TransactionServiceReports {
	List<TransactionDailyResponse> getUserSpendDailyTransactions(Long userId);

}
