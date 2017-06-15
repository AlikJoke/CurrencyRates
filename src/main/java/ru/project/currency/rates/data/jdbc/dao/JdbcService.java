package ru.project.currency.rates.data.jdbc.dao;

import java.util.List;

import javax.validation.constraints.NotNull;

import ru.project.currency.rates.data.jdbc.wrapper.BaseWrapper;
import ru.project.currency.rates.xml.model.Valute;

/**
 * Интерфейс доступа к операциям с РСУБД (асинхронный сервис).
 * 
 * @author Alimurad A. Ramazanov
 * @since 16.06.2017
 * @version 1.0.0
 *
 */
public interface JdbcService {

	/**
	 * Операция сохранения в БД.
	 * <p>
	 * 
	 * @see BaseWrapper
	 * @see Valute
	 * @see JdbcRepository
	 * 
	 * @param obj
	 *            - список объектов для сохранения; не может быть {@code null}.
	 */
	void save(@NotNull List<Valute> valutes);
}
