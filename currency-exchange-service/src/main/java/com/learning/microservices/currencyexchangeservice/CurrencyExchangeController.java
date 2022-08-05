package com.learning.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;

	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangevalue(@PathVariable("from") String fromCurrency,
			@PathVariable("to") String toCurrency) {

		String port = environment.getProperty("local.server.port");

		CurrencyExchange currencyExchange = new CurrencyExchange(1000L, fromCurrency, toCurrency,
				BigDecimal.valueOf(50));

		currencyExchange.setEnvironment(port);
		return currencyExchange;

	}

}
