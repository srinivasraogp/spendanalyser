package com.hcl.spendanalyser.repository;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.spendanalyser.beans.TransactionDailyResponse;
import com.hcl.spendanalyser.model.Transaction;

@Repository

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	@Query(value ="select  user_id ,transaction_date, sum(total) as total_price from transaction where user_id=:userId group by transaction_date order by transaction_date desc", nativeQuery = true)
	List<Transaction> getUserSpendDailyTransactions(@Param long userId);
}
