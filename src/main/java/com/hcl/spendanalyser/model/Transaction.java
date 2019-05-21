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
    private Long transaction_id;
    
	private Long user_id;
	private Long prod_id;
	private String prod_name;
	private Date transaction_date;
	private Integer qty;
	private BigDecimal price;
	private BigDecimal total;

}
