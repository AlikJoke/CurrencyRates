package ru.project.currency.rates.request.json;

import ru.project.currency.rates.json.model.Entries;
import ru.project.currency.rates.request.BaseRequestImpl;

public class JsonRequestImpl extends BaseRequestImpl implements JsonRequest {

	private static final String JSON_URL = "json.url";

	@Override
	public Entries execute() {
		// TODO
		return null;
	}

	@Override
	public String getRequestURL() {
		return props.getProperty(JSON_URL);
	}

}
