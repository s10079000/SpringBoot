package com.example.demo.controller.api;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Currency;
import com.example.demo.service.CurrencyCrudService;
import com.example.demo.service.CurrencyTransService;
import com.example.demo.utils.ReadJsonURL;


@RestController
@RequestMapping
public class TransController{
	
	@Autowired
	CurrencyTransService currencyTransService;
	@Autowired
	CurrencyCrudService currencyCrudService;
	
	@PostMapping("/coindesk")
	public String coindesk() {
		JSONObject json = null;
		try {
			json = new ReadJsonURL().readJsonFromUrl("https://api.coindesk.com/v1/bpi/currentprice.json");
		} catch (JSONException je) {
			je.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	    return json.toString();
	} 
	
	@PostMapping("/time")
	public String getTime(){
		return currencyTransService.getDateTime("yyyy-MM-dd HH:mm:ss");
	}
	
	@PostMapping("/coin")
	public String getCoin(){
		return currencyTransService.getCoinInfo();
	}
	
	@PostMapping("/select")
	public Currency select(@RequestBody Currency currency) {
		return currencyCrudService.selectCoin(currency.getCoinCode());
	}
	
	@PostMapping("/insert")
	public void insert(@RequestBody Currency currency) {
		currencyCrudService.insertCoin(currency);
	}
	
	@PostMapping("/update")
	public Currency update(@RequestBody Currency currency) {
		return currencyCrudService.updateCoin(currency);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody Currency currency) {
		currencyCrudService.deleteCoin(currency.getCoinCode());
	}
	
}
