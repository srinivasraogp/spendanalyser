package com.hcl.spendanalyser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.spendanalyser.beans.TransactionDailyResponse;
import com.hcl.spendanalyser.dto.MonthlyReportDTO;
import com.hcl.spendanalyser.dto.WeeklyReportDTO;
import com.hcl.spendanalyser.model.Transaction;

@Repository

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
//	@Query(value ="select  user_id ,transaction_date, sum(total) as total_price from transaction where user_id=:userId group by transaction_date order by transaction_date desc", nativeQuery = true)
//	List<TransactionDailyResponse> getUserSpendDailyTransactions(@Param("userId") Long userId);
	
	
	@Query("select  new com.hcl.spendanalyser.beans.TransactionDailyResponse( user_id, DATE(transaction_date), sum(total))"
            + " from Transaction where user_id=:userId group by DATE(transaction_date) order by DATE(transaction_date) desc")
    List<TransactionDailyResponse> getUserSpendDailyTransactions(@Param("userId") Long userId);
	

	@Query("SELECT new com.hcl.spendanalyser.dto.MonthlyReportDTO(t.user_id, MONTHNAME(STR_TO_DATE(month(t.transaction_date), '%m')), sum(t.total))"
			+ " FROM Transaction t WHERE t.user_id = :userId group by month(t.transaction_date) order by month(t.transaction_date) desc")
	List<MonthlyReportDTO> getMonthlyReport(@Param("userId") Long userId);
	
	@Query("SELECT new com.hcl.spendanalyser.dto.WeeklyReportDTO(t.user_id, week(t.transaction_date)+1, sum(t.total))"
			+ " FROM Transaction t WHERE t.user_id = :userId group by week(t.transaction_date) order by month(t.transaction_date) desc, day(transaction_date) desc")
	List<WeeklyReportDTO> getWeeklyReport(@Param("userId") Long userId);
}
