package ua.foxminded.javaspring.schooldb.FlywayMigration;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;

public class FlywayMigration {

	private final DataSource dataSource;

	public FlywayMigration(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void flywayMigration() {
		Flyway flyway = Flyway.configure().dataSource(dataSource).load();
		flyway.migrate();
	}
}
