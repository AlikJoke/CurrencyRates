package ru.project.currency.rates.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import ru.project.currency.rates.rest.base.model.Base;

@Configuration
public class RedisApplication {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
	    return new JedisConnectionFactory();
	}
	 
	@Bean
	public RedisTemplate<String, Base> redisTemplate() {
	    RedisTemplate<String, Base> template = new RedisTemplate<String, Base>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    return template;
	}
}
