package com.conferor.model;

import java.util.HashMap;
import java.util.Map;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExchangeRates {
	@Id
	private String id;
	private String base;
	private String date;
	private Map<String, Double> rates;
	
	public ExchangeRates() {
		super();
		rates = new HashMap<String, Double>();
	}
	
	public ExchangeRates(String base, String date, Map<String, Double> rates) {
		super();
		this.base = base;
		this.date = date;
		this.rates = rates;
	}
	
	@SuppressWarnings("unchecked")
	public ExchangeRates(String base, String date, Object rates) {
		super();
		ObjectMapper mapper = new ObjectMapper();
		
		this.base = base;
		this.date = date;
		this.rates = mapper.convertValue(rates, Map.class);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Map<String, Double> getRates() {
		return rates;
	}

	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		//mapper.setDefaultPrettyPrinter(null);
		try {
			return "ExchangeRates [base=" + base + ", date=" + date + ",\n rates=" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rates) + "]";
		} catch (JsonProcessingException e) {
			System.out.println("Some logging here");
			return "ExchangeRates [base=" + base + ", date=" + date + "]";
		}
	}
}
