package com.hcl.spendanalyser.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter @Getter @NoArgsConstructor
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;
	

    @Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long user_id;
	private Long prod_id;
	private Date date;
	private Integer qty;
	private BigDecimal amount;

}
