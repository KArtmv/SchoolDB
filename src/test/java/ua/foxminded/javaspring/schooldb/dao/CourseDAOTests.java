package ua.foxminded.javaspring.schooldb.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import ua.foxminded.javaspring.schooldb.SchoolDbApplicationTests;
import ua.foxminded.javaspring.schooldb.model.Course;
import ua.foxminded.javaspring.schooldb.model.Student;
import ua.foxminded.javaspring.schooldb.model.StudentAtCourse;

@TestMethodOrder(OrderAnnotation.class)
public class CourseDAOTests extends SchoolDbApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private CourseDAO courseDAO;
	private StudentDAO studentDAO;

	@BeforeEach
	void setUp() {
		courseDAO = new CourseDAOImpl(jdbcTemplate);
	}

	private Student studentID = new Student(1L);
	private Course courseID = new Course(1L);

	@Test
	void listOfCourse_test() {
		List<Course> courseList = courseDAO.listOfCourse();
		assertEquals(10, courseList.size());
	}

	@Test
	@Sql({ "/Students.sql", "/StudentsAtCourse.sql" })
	void listOfStudentsAtCourse_test() {
		List<StudentAtCourse> result = courseDAO.listOfStudentsAtCourse(courseID);

		assertNotNull(result);
		assertEquals(5, result.size());
	}

	@Test
	@Order(1)
	@Sql(statements = "insert into students (first_name, last_name, group_id) values ('Maya', 'Patel', 1)")
	void addStudentToCourse_test() {
		List<StudentAtCourse> checkIsEmpty = courseDAO.listOfStudentsAtCourse(courseID);

		boolean isAdded = courseDAO.addStudentToCourse(studentID, courseID);

		List<StudentAtCourse> checkIsAdded = courseDAO.listOfStudentsAtCourse(courseID);

		assertThat(checkIsEmpty).isEmpty();
		assertThat(isAdded).isTrue();
		assertEquals(1, checkIsAdded.size());
	}

	@Test
	@Order(2)
	void deleteStudentFromTheCourse_test() {
		List<StudentAtCourse> checkIsAre = courseDAO.listOfStudentsAtCourse(courseID);

		StudentAtCourse studentAtCourse = new StudentAtCourse(1L);
		boolean isDeleted = courseDAO.deleteStudentFromTheCourse(studentAtCourse);

		List<StudentAtCourse> checkIsDeleted = courseDAO.listOfStudentsAtCourse(courseID);

		assertEquals(1, checkIsAre.size());
		assertThat(isDeleted).isTrue();
		assertThat(checkIsDeleted).isEmpty();
	}

	@Test
	@Sql("/TheStudentToSeveralCourses.sql")
	@Order(3)
	void deleteStudentFromTheirAllCourses_test() {
		studentDAO = new StudentDAOImpl(jdbcTemplate);
		List<StudentAtCourse> coursesList = studentDAO.listOfCoursesOfStudent(studentID);

		boolean isDeleted = courseDAO.deleteStudentFromTheirAllCourses(studentID);

		List<StudentAtCourse> checkIsDeleted = studentDAO.listOfCoursesOfStudent(studentID);

		assertNotNull(coursesList);
		assertEquals(5, coursesList.size());
		assertThat(isDeleted).isTrue();
		assertThat(checkIsDeleted).isEmpty();
	}
}
