package com.hcl.spendanalyser.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @NoArgsConstructor @ToString
public class WeeklyReportDTO {

	private Long user_id;
	private Integer weekNumber;
	private BigDecimal amount;
	public WeeklyReportDTO(Long user_id, Integer weekNumber, BigDecimal amount) {
		super();
		this.user_id = user_id;
		this.weekNumber = weekNumber;
		this.amount = amount;
	}
	
}
