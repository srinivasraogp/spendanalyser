package com.hcl.spendanalyser.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @NoArgsConstructor @ToString
public class MonthlyReportDTO {

	private Long user_id;
	private String transaction_month;
	private BigDecimal amount;
	public MonthlyReportDTO(Long user_id, String transaction_month, BigDecimal amount) {
		super();
		this.user_id = user_id;
		this.transaction_month = transaction_month;
		this.amount = amount;
	}
	
}
