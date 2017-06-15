package ru.project.currency.rates.data.jdbc.wrapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import ru.project.currency.rates.xml.model.Valute;

public class BaseWrapper {

	private String id;
	private String name;
	private String value;
	private Integer numCode;
	private String charCode;
	private Timestamp timestamp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getNumCode() {
		return numCode;
	}

	public void setNumCode(Integer numCode) {
		this.numCode = numCode;
	}

	public String getCharCode() {
		return charCode;
	}

	public void setCharCode(String charCode) {
		this.charCode = charCode;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public BaseWrapper(final Valute valute) {
		this.id = valute.getID();
		this.timestamp = Timestamp.valueOf(LocalDateTime.now());
		this.name = valute.getName();
		this.value = valute.getValue();
		this.numCode = valute.getNumCode();
		this.charCode = valute.getCharCode();
	}
}
