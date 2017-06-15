package ru.project.currency.rates.request.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import ru.project.currency.rates.data.dao.impl.XmlRedisRepository;
import ru.project.currency.rates.request.BaseRequestImpl;
import ru.project.currency.rates.xml.model.Entries;

@Service
public class XmlRequestImpl extends BaseRequestImpl implements XmlRequest {

	@Autowired
	private XmlRedisRepository xmlRepository;

	private static final String XML_URL = "xml.url";

	@Override
	@Scheduled(initialDelay = 1000, fixedDelay = 1000)
	public Entries execute() {
		Entries obj = this.restTemplate.getForObject(this.getRequestURL(), Entries.class);
		if (obj == null)
			throw new IllegalStateException("Response can't be null!");

		xmlRepository.saveAllValutes(obj.getValutes());
		return obj;
	}

	@Override
	public String getRequestURL() {
		return this.props.getProperty(XML_URL);
	}
}
