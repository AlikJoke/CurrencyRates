package ru.project.currency.rates.request;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import ru.project.currency.rates.properties.Properties;

public abstract class BaseRequestImpl {

	@Autowired
	protected RestTemplate restTemplate;

	@Autowired
	protected Properties props;

	@PostConstruct
	public void init() {
		if (this.restTemplate == null)
			throw new RuntimeException("Resttemplate isn't injected yet!");

		if (this.props == null)
			throw new RuntimeException("Properties isn't injected yet!");
	}
}
