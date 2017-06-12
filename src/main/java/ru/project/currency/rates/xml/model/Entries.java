package ru.project.currency.rates.xml.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.assertj.core.util.Lists;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.xml.annotate.JacksonXmlProperty;
import com.fasterxml.jackson.xml.annotate.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "ValCurs")
public class Entries {

	@JacksonXmlProperty(isAttribute = true, localName = "Date")
	@NotEmpty
	@NotNull
	public String Date;

	@JacksonXmlProperty(isAttribute = true, localName = "name")
	public String name;

	@JacksonXmlElementWrapper(localName = "Valute", useWrapping = false)
	@NotEmpty
	@NotNull
	public List<Valute> Valute;

	public String getDate() {
		return Date;
	}

	public void setDate(String Date) {
		this.Date = Date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Valute> getValutes() {
		return Lists.newArrayList(Valute);
	}

	public void setValutes(List<Valute> valutes) {
		this.Valute = valutes;
	}

	public Entries(String date, String name, List<Valute> valutes) {
		super();
		this.Date = date;
		this.name = name;
		this.Valute = valutes;
	}

	public Entries() {
		super();
	}
}
