package ru.project.currency.rates.data.jdbc.queries;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import ru.project.currency.rates.data.jdbc.wrapper.BaseWrapper;

public class JdbcQueries {

	public final static String INSERT = "INSERT INTO valutes VALUES (?, ?::timestamp, ?, ?, ?, ?)";
	public final static String DELETE = "DELETE FROM valutes WHERE id = ?";
	public final static String SELECT = "SELECT id, dt, name, value, charCode, numCode FROM valutes WHERE id = ? and dt = ?::timestamp";
	public final static String SELECT_BY_ID = "SELECT id, dt, name, value, charCode, numCode FROM valutes WHERE id = ?";
	public final static String SELECT_ALL = "SELECT id, dt, name, value, charCode, numCode FROM valutes";

	private static BaseWrapper wrapObject(ResultSet rse) throws SQLException {
		BaseWrapper wrapper = null;
		if (rse.next()) {
			wrapper = new BaseWrapper();
			wrapper.setId(rse.getString("id"));
			wrapper.setTimestamp(rse.getTimestamp("dt"));
			wrapper.setName(rse.getString("name"));
			wrapper.setValue(rse.getString("value"));
			wrapper.setCharCode(rse.getString("charCode"));
			wrapper.setNumCode(rse.getInt("numCode"));
		}
		return wrapper;
	}

	public static ResultSetExtractor<BaseWrapper> extractor = rse -> wrapObject(rse);

	public static RowMapper<BaseWrapper> mapper = (rs, rw) -> wrapObject(rs);
}
