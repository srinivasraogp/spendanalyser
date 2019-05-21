package com.hcl.spendanalyser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.spendanalyser.dto.MonthlyReportDTO;
import com.hcl.spendanalyser.model.Transaction;

@Repository

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	@Query(value ="select  user_id ,transaction_date, sum(total) as total_price from transaction where user_id=:userId group by transaction_date order by transaction_date desc", nativeQuery = true)
	List<Transaction> getUserSpendDailyTransactions(@Param("userId") Long userId);

	@Query("SELECT new com.hcl.spendanalyser.dto.MonthlyReportDTO(t.user_id, MONTHNAME(STR_TO_DATE(month(t.transaction_date), '%m')), sum(t.total))"
			+ " FROM Transaction t WHERE t.user_id = :userId group by month(t.transaction_date) order by day(t.transaction_date) desc")
	List<MonthlyReportDTO> getMonthlyReport(@Param("userId") Long userId);
}
