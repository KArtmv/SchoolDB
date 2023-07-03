package ua.foxminded.javaspring.schooldb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import ua.foxminded.javaspring.schooldb.dao.CourseDAO;
import ua.foxminded.javaspring.schooldb.dao.CourseDAOImpl;
import ua.foxminded.javaspring.schooldb.model.Course;

class CourseDAOTests extends SchoolDbApplicationTests {

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
