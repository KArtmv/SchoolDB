package ua.foxminded.javaspring.schooldb.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import ua.foxminded.javaspring.schooldb.SchoolDbApplicationTests;
import ua.foxminded.javaspring.schooldb.model.Course;

public class CourseDAOTests extends SchoolDbApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private CourseDAO courseDAO;

	@BeforeEach
	void setUp() {
		courseDAO = new CourseDAOImpl(jdbcTemplate);
	}

	@Test
	void listOfCourse_test() {
		List<Course> courseList = courseDAO.listOfCourse();
		assertEquals(10, courseList.size());
	}
}
