package com.conferor.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.conferor.model.ExchangeRates;
import com.conferor.repository.ExchangeRatesRepository;

@RestController
@RequestMapping("/exchangerates")
public class ExchangeRatesController {
	@Autowired
	private ExchangeRatesRepository exchangeRatesRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public Map<String, String> createExchangeRates(@RequestBody Map<String, Object> exchangeRatesMap){
		ExchangeRates exchangeRates = new ExchangeRates(
			exchangeRatesMap.get("base").toString(),
			exchangeRatesMap.get("date").toString(),
			exchangeRatesMap.get("rates")
		);
		System.out.println(exchangeRates);
		exchangeRatesRepository.save(exchangeRates);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "ExchangeRates created successfully");
		response.put("ExchangeRates", "EUR based");
		//response.put("ExchangeRates", exchangeRates);
	    return response;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{exchangeRatesId}")
	public ExchangeRates getBookDetails(@PathVariable("exchangeRatesId") String exchangeRatesId){
		return exchangeRatesRepository.findOne(exchangeRatesId);
	}
}
