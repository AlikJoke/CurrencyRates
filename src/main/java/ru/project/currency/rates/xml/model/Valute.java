package ru.project.currency.rates.xml.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.xml.annotate.JacksonXmlProperty;
import com.fasterxml.jackson.xml.annotate.JacksonXmlRootElement;

import ru.project.currency.rates.rest.base.model.Base;

@JacksonXmlRootElement(localName = "Valute")
public class Valute extends Base {

	private static final long serialVersionUID = 37074093391280334L;

	@JacksonXmlProperty(isAttribute = true, localName = "ID")
	@NotEmpty
	@NotNull
	public String ID;

	@JacksonXmlProperty(localName = "NumCode")
	@NotNull
	public Integer NumCode;

	@JacksonXmlProperty(localName = "CharCode")
	@NotEmpty
	@NotNull
	public String CharCode;

	@JacksonXmlProperty(localName = "Nominal")
	@NotNull
	public Integer Nominal;

	@JacksonXmlProperty(localName = "Name")
	@NotEmpty
	@NotNull
	public String Name;

	@JacksonXmlProperty(localName = "Value")
	@NotEmpty
	@NotNull
	public String Value;

	public Valute() {
		super();
	}

	public String getID() {
		return this.ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public Integer getNumCode() {
		return this.NumCode;
	}

	public void setNumCode(Integer numCode) {
		this.NumCode = numCode;
	}

	public String getCharCode() {
		return this.CharCode;
	}

	public void setCharCode(String charCode) {
		this.CharCode = charCode;
	}

	public Integer getNominal() {
		return this.Nominal;
	}

	public void setNominal(Integer nominal) {
		this.Nominal = nominal;
	}

	public String getName() {
		return this.Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getValue() {
		return this.Value;
	}

	public void setValue(String value) {
		this.Value = value;
	}
}