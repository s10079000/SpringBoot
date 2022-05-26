package com.example.demo.service;

import com.example.demo.entity.Currency;

public interface CurrencyCrudService {
	
	public Currency insertCoin(Currency currency);
	
	public void deleteCoin(String coinCode);
	
	public Currency selectCoin(String coinCode);
	
	public Currency updateCoin(Currency currency);
	
}
