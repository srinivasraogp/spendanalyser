package com.hcl.spendanalyser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.spendanalyser.dto.ProductMonthlyReportDTO;
import com.hcl.spendanalyser.model.Transaction;

@Repository
public interface ProductRepository extends JpaRepository<Transaction, Long> {

	@Query("SELECT new com.hcl.spendanalyser.dto.ProductMonthlyReportDTO(t.prod_id, MONTHNAME(STR_TO_DATE(month(t.transaction_date), '%m')), sum(t.total))"
			+ " FROM Transaction t WHERE t.prod_id = :prodId group by month(t.transaction_date) order by day(t.transaction_date) desc")
	List<ProductMonthlyReportDTO> getMonthlyReport(@Param("prodId") Long prodId);
}
