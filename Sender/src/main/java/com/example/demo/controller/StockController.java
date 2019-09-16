package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {
	
	@Autowired
	JmsTemplate jmstemp;
	
	@GetMapping("/{symbol}")
	public String getStock(@PathVariable String symbol)
	{
		jmstemp.convertAndSend("StockQueue",symbol);
		
		return "you will recieve the stock value soon";
	}

}
