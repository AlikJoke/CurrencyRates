package ru.project.currency.rates.data.jdbc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import ru.project.currency.rates.data.jdbc.dao.JdbcRepository;
import ru.project.currency.rates.data.jdbc.dao.JdbcService;
import ru.project.currency.rates.data.jdbc.wrapper.BaseWrapper;
import ru.project.currency.rates.xml.model.Valute;

@Service
public class JdbcServiceImpl implements JdbcService {

	@Autowired
	private JdbcRepository repository;

	@Override
	@Async
	public void save(List<Valute> obj) {
		obj.forEach(val -> repository.save(new BaseWrapper(val)));
	}
}
