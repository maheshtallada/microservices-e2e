package com.learning.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangevalue(@PathVariable("from") String fromCurrency,
			@PathVariable("to") String toCurrency) {

		return new CurrencyExchange(1000L, fromCurrency, toCurrency, BigDecimal.valueOf(50));

	}

}
