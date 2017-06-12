package ru.project.currency.rates.rest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Lists;

@Configuration
public class RestApplication {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		RestTemplate template = builder.build();
		template.setMessageConverters(Lists.newArrayList(xmlMessageConverter(), jsonMessageConverter()));
		return template;
	}

	@Bean
	public HttpMessageConverter<Object> xmlMessageConverter() {
		return new MappingJackson2XmlHttpMessageConverter();
	}

	@Bean
	public HttpMessageConverter<Object> jsonMessageConverter() {
		return new MappingJackson2HttpMessageConverter();
	}

}
