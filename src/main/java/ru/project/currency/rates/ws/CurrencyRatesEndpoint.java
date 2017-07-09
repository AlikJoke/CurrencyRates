package ru.project.currency.rates.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import ru.project.currency.rates.data.dao.impl.XmlRedisRepository;
import ru.project.currency.rates.xml.model.Valute;

@Endpoint
public class CurrencyRatesEndpoint {

	private static final String NAMESPACE_URL = "http://localhost:8080/CurrencyRates/api";

	@Autowired
	private XmlRedisRepository repository;

	@PayloadRoot(namespace = NAMESPACE_URL, localPart = "getCurrencyRateById")
	@ResponsePayload
	public Object getCurrencyRateById(@RequestPayload String id) {
		Valute valute = this.repository.getValute(id);
		// TODO
		return null;
	}

	@PayloadRoot(namespace = NAMESPACE_URL, localPart = "removeCurrencyRateById")
	@ResponsePayload
	public Object removeCurrencyRateById(@RequestPayload String id) {
		Valute valute = this.repository.getValute(id);
		this.repository.removeValute(id);
		// TODO
		return null;
	}
}
