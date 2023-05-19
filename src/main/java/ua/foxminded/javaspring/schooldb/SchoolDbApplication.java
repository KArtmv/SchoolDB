package ua.foxminded.javaspring.schooldb;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ua.foxminded.javaspring.schooldb.FlywayMigration.FlywayMigration;
import ua.foxminded.javaspring.schooldb.config.SpringJdbcConfig;

@SpringBootApplication
public class SchoolDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolDbApplication.class, args);
		SpringJdbcConfig jdbcConfig = new SpringJdbcConfig();

		AnnotationConfigApplicationContext contex = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
		DataSource dataSource = jdbcConfig.postDataSource();

		FlywayMigration migration = new FlywayMigration(dataSource);
		migration.flywayMigration();
		Starter starter = new Starter(contex);
		starter.appStart();
	}
}
