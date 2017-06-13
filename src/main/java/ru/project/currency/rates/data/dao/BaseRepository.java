package ru.project.currency.rates.data.dao;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import ru.project.currency.rates.rest.base.model.Base;

public abstract class BaseRepository {

	@Autowired
	protected RedisTemplate<String, Base> redisTemplate;

	protected HashOperations<String, String, Base> hashOps;

	@PostConstruct
	public void init() {
		if (redisTemplate == null)
			throw new RuntimeException("RedisTemplate isn't injected!");

		this.hashOps = redisTemplate.opsForHash();
		if (this.hashOps == null)
			throw new RuntimeException("HashOps can't be null!");
	}
}
