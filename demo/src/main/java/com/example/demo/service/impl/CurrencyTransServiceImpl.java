package com.example.demo.service.impl;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Currency;
import com.example.demo.reponsitory.CurrencyRepository;
import com.example.demo.service.CurrencyTransService;

@Service
public class CurrencyTransServiceImpl extends AbstractServiceImpl implements CurrencyTransService{

	@Autowired
	CurrencyRepository currencyRepository;
	
	/**
	 * 格式化ISO時間
	 * 
	 * @param pattern 時間格式
	 * @return	格式化後datetime
	 * 
	 */
	public String getDateTime(String pattern) {
		
		//更新時間
		String updatedISO = String.valueOf(getForm().getJSONObject("time").get("updatedISO"));	
		//設定時間
		OffsetDateTime odt = OffsetDateTime.parse(updatedISO);
		//設定新的時間格式
		DateTimeFormatter sdf = DateTimeFormatter.ofPattern(pattern);
		
		//格式化時間
		return sdf.format(odt);
	}
	
	/**
	 * 重組API內容
	 * 
	 * @return	幣別,幣別中文名稱,匯率
	 */
	public String getCoinInfo(){
		
		List<Map<String, Object>> coinInfoArray = new ArrayList<Map<String, Object>>();
		
		JSONObject coinGroup = getForm().getJSONObject("bpi");
		Map<String, String> dataMap = new HashMap<String, String>();
		Iterator data = getData().iterator();
		Iterator coin = coinGroup.keys();
		
		//取資料庫資料
		while(data.hasNext()) {
			Currency currency = (Currency)data.next();
			dataMap.put(currency.getCoinCode(),currency.getCName());
		}
		
		//重組API所需資料
		while(coin.hasNext()) {
			Map<String, Object> coinInfo = new HashMap<String, Object>();
			Map<String ,Object> dollar = coinGroup.getJSONObject(String.valueOf(coin.next())).toMap();
			
			coinInfo.put("幣別",dollar.get("code"));
			coinInfo.put("幣別中文名稱",dataMap.get(dollar.get("code")));
			coinInfo.put("匯率",dollar.get("rate"));
			coinInfoArray.add(coinInfo);
		}
		
		return String.valueOf(new JSONArray(coinInfoArray));
	}
	
	/**
	 * @return Iterable<Currency>
	 */
	public Iterable<Currency> getData(){
		return currencyRepository.findAll();
	}

}
