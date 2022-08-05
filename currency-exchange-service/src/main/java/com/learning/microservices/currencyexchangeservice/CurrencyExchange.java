package com.learning.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class CurrencyExchange {

	@Id
	private Long id;
	
	@Column(name = "currencyFrom")
	private String from;
	
	@Column(name = "currencyTo")
	private String to;
	
	private BigDecimal conversionMultiple;
	private String environment;

	public CurrencyExchange(Long id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}
}
