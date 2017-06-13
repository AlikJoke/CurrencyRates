package ru.project.currency.rates.utils;

import javax.validation.constraints.NotNull;

public class UniCast {

	/**
	 * Производит преобразования между типами. Если типы несовместимы, бросает
	 * IllegalArgumentException.
	 * <p>
	 * 
	 * @param clazz
	 *            - целевой класс объекта; не может быть {@code null}.
	 * @param obj
	 *            - объект, который должен быть преобразован; не может быть
	 *            {@code null}.
	 * @return преобразованный объект нужного типа; не может быть {@code null}.
	 * @throws IllegalArgumentException
	 */
	@NotNull
	public static <T> T cast(@NotNull Class<T> clazz, @NotNull Object obj) {
		if (!clazz.isInstance(obj))
			throw new IllegalArgumentException("Non-compatible types!");
		return clazz.cast(obj);
	}
}
