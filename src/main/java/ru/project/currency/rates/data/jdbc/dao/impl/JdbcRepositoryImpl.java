package ru.project.currency.rates.data.jdbc.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.project.currency.rates.data.jdbc.dao.JdbcRepository;
import ru.project.currency.rates.data.jdbc.queries.JdbcQueries;
import ru.project.currency.rates.data.jdbc.wrapper.BaseWrapper;

@Repository	
public class JdbcRepositoryImpl implements JdbcRepository {

	@Autowired
	private JdbcTemplate template;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void save(BaseWrapper obj) {
		template.update(JdbcQueries.INSERT, pss -> {
			pss.setString(1, obj.getId());
			pss.setTimestamp(2, obj.getTimestamp());
			pss.setString(3, obj.getName());
			pss.setString(4, obj.getValue());
			pss.setString(5, obj.getCharCode());
			pss.setInt(6, obj.getNumCode());
		});
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void delete(String id) {
		template.update(JdbcQueries.DELETE, pss -> pss.setString(1, id));
	}

	@Override
	@Transactional(readOnly = true)
	public BaseWrapper get(String id, Timestamp dt) {
		return template.query(JdbcQueries.SELECT, new Object[] { id, dt }, JdbcQueries.extractor);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BaseWrapper> get(String id) {
		return template.query(JdbcQueries.SELECT_BY_ID, new Object[] { id }, JdbcQueries.mapper);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BaseWrapper> getAll() {
		return template.query(JdbcQueries.SELECT_ALL, JdbcQueries.mapper);
	}

}
