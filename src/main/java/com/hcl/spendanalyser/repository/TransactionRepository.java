package com.hcl.spendanalyser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.spendanalyser.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	
}
