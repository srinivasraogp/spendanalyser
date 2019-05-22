package com.hcl.spendanalyser.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @NoArgsConstructor @ToString
public class ProductMonthlyReportDTO {

	private Long prod_id;
	private String transaction_month;
	private BigDecimal amount;
	public ProductMonthlyReportDTO(Long prod_id, String transaction_month, BigDecimal amount) {
		super();
		this.prod_id = prod_id;
		this.transaction_month = transaction_month;
		this.amount = amount;
	}
	
}
