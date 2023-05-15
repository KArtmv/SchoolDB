package ua.foxminded.javaspring.schooldb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SchoolDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolDbApplication.class, args);

		AnnotationConfigApplicationContext contex = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
		Starter starter = new Starter(contex);
		starter.appStart();
	}
}
