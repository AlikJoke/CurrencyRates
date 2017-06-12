package ru.project.currency.rates.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.client.RestTemplate;

/**
 * Базовый интерфейс для запроса курса валют.
 * 
 * @author Alimurad A. Ramazanov
 * @since 13.06.2017
 * @version 1.0.0
 *
 */
public interface BaseRequest<T> {

	/**
	 * Выполняет запрос получения данных от ЦБ.
	 * <p>
	 * 
	 * @see RestTemplate
	 * @return не может быть {@code null}.
	 * @throws IllegalStateException,
	 *             если результат запроса == {@code null}.
	 */
	@NotNull
	T execute();

	/**
	 * Получение URL для данного типа сервиса (XML, JSON).
	 * <p>
	 * 
	 * @see RestTemplate
	 * @return не может быть {@code null}.
	 * @throws IllegalStateException,
	 *             если результат запроса == {@code null}.
	 */
	@NotNull
	@NotEmpty
	String getRequestURL();
}
