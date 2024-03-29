package com.ibm.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Feign Client service
//@FeignClient(name="currency-exchange-service",url="localhost:8000")
//End Feign Client service

//using Ribbon Load Balancer

@FeignClient(name="currency-exchange-service")
@RibbonClient(name="currency-exchange-service")

//End using Ribbon Load Balancer
public interface CurrencyExchangeServiceProxy {
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(
			@PathVariable("from") String from, @PathVariable("to") String to);

}
