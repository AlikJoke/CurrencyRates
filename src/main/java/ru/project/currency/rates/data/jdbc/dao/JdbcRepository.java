package ru.project.currency.rates.data.jdbc.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.NotEmpty;

import ru.project.currency.rates.data.jdbc.wrapper.BaseWrapper;

/**
 * Интерфейс доступа к операциям с РСУБД.
 * 
 * @author Alimurad A. Ramazanov
 * @since 16.06.2017
 * @version 1.0.0
 *
 */
public interface JdbcRepository {

	/**
	 * Операция сохранения в БД.
	 * <p>
	 * 
	 * @see BaseWrapper
	 * @see JdbcTemplate
	 * 
	 * @param obj
	 *            - объект для сохранения; не может быть {@code null}.
	 */
	void save(@NotNull BaseWrapper obj);

	/**
	 * Операция удаления из БД.
	 * <p>
	 * 
	 * @see BaseWrapper
	 * @see JdbcTemplate
	 * 
	 * @param id
	 *            - идентификатор для удаления; не может быть {@code null} или
	 *            {@code String#isEmpty()}.
	 */
	void delete(@NotNull @NotEmpty String id);

	/**
	 * Операция получения объекта из БД по идентификатору.
	 * <p>
	 * 
	 * @see BaseWrapper
	 * @see JdbcTemplate
	 * 
	 * @param id
	 *            - идентификатор объекта; не может быть {@code null} или
	 *            {@code String#isEmpty()}.
	 * @return не может быть {@code List#isEmpty()}
	 */
	@NotNull
	List<BaseWrapper> get(@NotNull @NotEmpty String id);

	/**
	 * Операция получения объекта из БД по идентификатору и времени.
	 * <p>
	 * 
	 * @see BaseWrapper
	 * @see JdbcTemplate
	 * 
	 * @param id
	 *            - идентификатор объекта; не может быть {@code null} или
	 *            {@code String#isEmpty()}.
	 * @param dt
	 *            - время загрузки объекта; не может быть {@code null}
	 * @return может быть {@code null}
	 */
	@Null
	BaseWrapper get(@NotNull @NotEmpty String id, @NotNull Timestamp dt);

	/**
	 * Операция получения объекта из БД <b>всех</b> объектов.
	 * <p>
	 * 
	 * @see BaseWrapper
	 * @see JdbcTemplate
	 * 
	 * @return не может быть {@code List#isEmpty()}
	 */
	@NotNull
	List<BaseWrapper> getAll();
}
