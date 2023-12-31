package ua.foxminded.javaspring.schooldb;

import org.junit.platform.suite.api.SelectPackages;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest
@ActiveProfiles("test")
@SelectPackages("ua.foxminded.javaspring.schooldb")
public abstract class SchoolDbApplicationTests {
	
	@MockBean
	Starter starter;

	static final PostgreSQLContainer<?> POSTGRES_CONTAINER;

	static {
		POSTGRES_CONTAINER = new PostgreSQLContainer<>("postgres:14.6");
		POSTGRES_CONTAINER.start();
	}

	@DynamicPropertySource
	private static void setupProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", POSTGRES_CONTAINER::getJdbcUrl);
		registry.add("spring.datasource.username", POSTGRES_CONTAINER::getUsername);
		registry.add("spring.datasource.password", POSTGRES_CONTAINER::getPassword);
	}
}
