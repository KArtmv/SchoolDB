package ua.foxminded.javaspring.schooldb.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan
public class SpringJdbcConfig {
	@Bean
	public DataSource postDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/schoolDB");
		dataSource.setUsername("admin");
		dataSource.setPassword("admin");
		dataSource.setSchema("public");
		return dataSource;
	}
}
