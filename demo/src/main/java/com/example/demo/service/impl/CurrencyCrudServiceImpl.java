package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Currency;
import com.example.demo.reponsitory.CurrencyRepository;
import com.example.demo.service.CurrencyCrudService;

@Service
public class CurrencyCrudServiceImpl implements CurrencyCrudService {
	
	@Autowired
	CurrencyRepository currencyRepository;
	
	/**
	 * 新增幣別
	 * @param coinCode
	 * @param cName
	 * @return Currency
	 */
	public Currency insertCoin(Currency currency) {
		return currencyRepository.save(currency);
	}
	
	/**
	 * 刪除幣別
	 * @param coinCode
	 */
	public void deleteCoin(String coinCode) {
		currencyRepository.deleteByCoinCode(coinCode);
	}
	
	/**
	 * 查詢幣別
	 * @param coinCode
	 * @return Currency
	 */
	public Currency selectCoin(String coinCode) {
		return currencyRepository.findByCoinCode(coinCode);
	}
	
	/**
	 * 更新幣別
	 * @param coinCode
	 * @param cName
	 */
	public Currency updateCoin(Currency currency) {	
		return currencyRepository.save(currency);
	}
	
}
