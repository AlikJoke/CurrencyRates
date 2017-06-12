package ru.project.currency.rates.request.xml;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import ru.project.currency.rates.request.BaseRequestImpl;
import ru.project.currency.rates.xml.model.Entries;

@Service
public class XmlRequestImpl extends BaseRequestImpl implements XmlRequest {

	private static final String XML_URL = "xml.url";

	@Override
	@Scheduled(initialDelay = 1000, fixedDelay = 1000)
	public Entries execute() {
		Entries obj = this.restTemplate.getForObject(this.getRequestURL(), Entries.class);
		if (obj == null)
			throw new IllegalStateException("Response can't be null!");

		// TODO save in redis
		return obj;
	}

	@Override
	public String getRequestURL() {
		return this.props.getProperty(XML_URL);
	}
}
