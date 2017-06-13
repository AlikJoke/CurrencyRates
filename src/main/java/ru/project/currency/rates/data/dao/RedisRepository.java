package ru.project.currency.rates.data.dao;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import ru.project.currency.rates.rest.base.model.Base;

/**
 * Базовый интерфейс для работы с данными, хранимыми в Redis.
 * 
 * @author Alimurad A. Ramazanov
 * @since 14.06.2017
 * @version 1.0.0
 *
 * @param <T>
 */
public interface RedisRepository<T extends Base> {

	/**
	 * Сохранение в Redis списка объектов.
	 * <p>
	 * 
	 * @see RedisTemplate
	 * @see HashOperations
	 * 
	 * @param valutes
	 *            - список валют, не может быть {@code null} или
	 *            {@code List#isEmpty()}.
	 */
	void saveAllValutes(@NotNull @NotEmpty List<T> valutes);

	/**
	 * Сохранение в Redis объекта валюты.
	 * <p>
	 * 
	 * @see RedisTemplate
	 * @see HashOperations
	 * 
	 * @param valute
	 *            - объект валюты, не может быть {@code null}.
	 */
	void saveValute(@NotNull T valute);

	/**
	 * Удаляет из Redis объект валюты по идентификатору.
	 * <p>
	 * 
	 * @see RedisTemplate
	 * @see HashOperations
	 * 
	 * @param id
	 *            - идентификатор валюты, не может быть {@code null} или
	 *            {@code String#isEmpty()}.
	 */
	void removeValute(@NotNull @NotEmpty String id);

	/**
	 * Удаляет из Redis объекты валюты по списку идентификаторов.
	 * <p>
	 * 
	 * @see RedisTemplate
	 * @see HashOperations
	 * 
	 * @param ids
	 *            - список идентификатор валюты, не может быть {@code null}.
	 */
	void removeValutes(@NotNull @NotEmpty Iterable<String> ids);

	/**
	 * Получает из Redis объект валюты по идентификатору.
	 * <p>
	 * 
	 * @see RedisTemplate
	 * @see HashOperations
	 * 
	 * @param id
	 *            - список идентификатор валюты, не может быть {@code null} или
	 *            {@code List#isEmpty()}.
	 * @return может быть {@code null}, если объект не найден.
	 */
	@Null
	T getValute(@NotNull @NotEmpty String id);

	/**
	 * Получает из Redis объекты валюты.
	 * <p>
	 * 
	 * @see RedisTemplate
	 * @see HashOperations
	 * 
	 * @return не может быть {@code null}.
	 */
	@NotNull
	List<T> getAllValutes();
}
