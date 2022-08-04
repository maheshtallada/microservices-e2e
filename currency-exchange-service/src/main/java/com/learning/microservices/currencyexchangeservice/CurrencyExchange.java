package com.learning.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchange {

	private Long id;				
	private String from;					
	private String to;						
	private BigDecimal conversionMultiple;
	//private String environment;				

}
