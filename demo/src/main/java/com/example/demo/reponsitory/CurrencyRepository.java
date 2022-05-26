package com.example.demo.reponsitory;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {
	
	Currency findByCoinCode(String coinCode);
	
	@Modifying
	@Transactional
	void deleteByCoinCode(String coinCode);
}
