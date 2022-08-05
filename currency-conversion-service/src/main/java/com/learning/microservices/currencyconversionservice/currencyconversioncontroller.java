package com.learning.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class currencyconversioncontroller {
	
	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retrieveExchangevalue(
			@PathVariable("from") String fromCurrency,
			@PathVariable("to") String toCurrency,
			@PathVariable BigDecimal quantity) {

		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", fromCurrency);
		uriVariables.put("to", toCurrency);
		
		// second parameter is the response model i.e., the CurrencyExchange
		// however as the parameters matches in both the classes, we can go 
		//with CurrencyConversion
		ResponseEntity<CurrencyConversion> response = new RestTemplate().getForEntity
			("http://localhost:8000/currency-exchange/from/{from}/to/{to}"
					, CurrencyConversion.class, uriVariables);
		
		CurrencyConversion currencyConversion = response.getBody();
		return new CurrencyConversion(
				currencyConversion.getId(), fromCurrency, toCurrency, quantity, 
				currencyConversion.getConversionMultiple(), 
				quantity.multiply(currencyConversion.getConversionMultiple()), 
				currencyConversion.getEnvironment());
	}

}
