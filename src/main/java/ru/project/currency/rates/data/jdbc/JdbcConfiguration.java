package ru.project.currency.rates.data.jdbc;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ru.project.currency.rates.properties.Properties;

@EnableTransactionManagement
@Configuration
public class JdbcConfiguration {

	@Autowired
	private Properties props;

	@Bean
	@Lazy
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(props.getProperty("spring.datasource.driver-class-name"));
		dataSource.setDefaultAutoCommit(false);
		dataSource.setUsername(props.getProperty("spring.datasource.username"));
		dataSource.setPassword(props.getProperty("spring.datasource.password"));
		dataSource.setUrl(props.getProperty("spring.datasource.url"));
		return dataSource;
	}
}
