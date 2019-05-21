package com.hcl.spendanalyser.beans;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class TransactionDailyResponse {
	private long user_id;
	private Date transaction_date;
	private BigDecimal total;

}
