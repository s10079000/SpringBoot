package com.example.demo.service.impl;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.service.AbstractService;
import com.example.demo.utils.ReadJsonURL;


@Component
public class AbstractServiceImpl implements AbstractService {
	
	
	@Autowired
	private ReadJsonURL readJsonURL;

	public JSONObject getForm() {		
		JSONObject json = null;
		try {
			json = readJsonURL.readJsonFromUrl("https://api.coindesk.com/v1/bpi/currentprice.json");
		} catch (JSONException je) {
			je.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}	
		return json;
	}
}
