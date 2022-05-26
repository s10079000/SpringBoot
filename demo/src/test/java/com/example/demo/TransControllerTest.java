package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class TransControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void coindesk() throws Exception{
		
		//設定標頭
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		
		//設定請求
		RequestBuilder requestBuilder = 
				MockMvcRequestBuilders
				.post("/coindesk")
				.headers(httpHeaders);
		
		mockMvc.perform(requestBuilder)
		.andDo(print())
		.andExpect(status().isOk());
		
	}
	
	@Test
	public void time() throws Exception{
		
		//設定標頭
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		
		//設定請求
		RequestBuilder requestBuilder = 
				MockMvcRequestBuilders
				.post("/time")
				.headers(httpHeaders);
		
		mockMvc.perform(requestBuilder)
		.andDo(print())
		.andExpect(status().isOk());
		
	}
	
	@Test
	public void select() throws Exception{

		//設定標頭
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		
		//設定參數
		JSONObject request = new JSONObject()
				.put("coinCode", "USD");
		
		//設定請求
		RequestBuilder requestBuilder = 
				MockMvcRequestBuilders
					.post("/select")
					.headers(httpHeaders)
					.content(request.toString());
		
		mockMvc.perform(requestBuilder)
			.andDo(print())
			.andExpect(status().isOk());

	}
	
	@Test
	public void insert() throws Exception{
		
		//設定標頭
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		
		//設定參數
		JSONObject request = new JSONObject()
				.put("coinCode", "NTD")
				.put("cname", "新臺幣");
		
		//設定請求
		RequestBuilder requestBuilder = 
				MockMvcRequestBuilders
				.post("/insert")
				.headers(httpHeaders)
				.content(request.toString());
		
		mockMvc.perform(requestBuilder)
		.andExpect(status().isOk());
		
	}
	
	@Test
	public void update() throws Exception{
		
		//設定標頭
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		
		//設定參數
		JSONObject request = new JSONObject()
				.put("coinCode", "JPY")
				.put("cname", "日圓");
		
		//設定請求
		RequestBuilder requestBuilder = 
				MockMvcRequestBuilders
				.post("/update")
				.headers(httpHeaders)
				.content(request.toString());
		
		mockMvc.perform(requestBuilder)
		.andDo(print())
		.andExpect(status().isOk());
		
	}
	
	@Test
	public void delete() throws Exception{
		
		//設定標頭
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		
		//設定參數
		JSONObject request = new JSONObject()
				.put("coinCode", "JPY");
		
		//設定請求
		RequestBuilder requestBuilder = 
				MockMvcRequestBuilders
				.post("/delete")
				.headers(httpHeaders)
				.content(request.toString());
		
		mockMvc.perform(requestBuilder)
		.andExpect(status().isOk());
		
	}
	
}
