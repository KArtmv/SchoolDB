package ua.foxminded.javaspring.schooldb;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ua.foxminded.javaspring.schooldb.FlywayMigration.FlywayMigration;

@SpringBootApplication
public class SchoolDbApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext contex = SpringApplication.run(SchoolDbApplication.class, args);

		DataSource dataSource = contex.getBean(DataSource.class);

		FlywayMigration migration = new FlywayMigration(dataSource);
		migration.flywayMigration();

		Starter starter = contex.getBean(Starter.class);
		starter.appStart();
	}
}
