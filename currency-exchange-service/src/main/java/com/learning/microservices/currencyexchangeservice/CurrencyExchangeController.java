package com.learning.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private CurrencyExchangeRepository repo;
	
	@Autowired
	private Environment environment;

	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangevalue(
			@PathVariable("from") String fromCurrency,
			@PathVariable("to") String toCurrency) {

		String port = environment.getProperty("local.server.port");

		CurrencyExchange currencyExchange = 
//				new CurrencyExchange(1000L, fromCurrency, toCurrency,
//				BigDecimal.valueOf(50));
				repo.findByFromAndTo(fromCurrency, toCurrency);

		if (currencyExchange == null) {
			throw new RuntimeException
				("Unable to find data for "+fromCurrency+" to "+toCurrency);
		}
		currencyExchange.setEnvironment(port);
		return currencyExchange;

	}

}
