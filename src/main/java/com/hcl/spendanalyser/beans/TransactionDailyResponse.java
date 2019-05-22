package com.hcl.spendanalyser.beans;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @NoArgsConstructor @ToString
public class TransactionDailyResponse {
	private Long user_id;
	private Date transaction_date;
	private BigDecimal total;
	
	public TransactionDailyResponse(Long user_id, Date transaction_date, BigDecimal total) {
		super();
		this.user_id = user_id;
		this.transaction_date = transaction_date;
		this.total = total;
	}

}
