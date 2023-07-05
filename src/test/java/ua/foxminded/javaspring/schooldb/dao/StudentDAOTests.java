package ua.foxminded.javaspring.schooldb.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import ua.foxminded.javaspring.schooldb.SchoolDbApplicationTests;
import ua.foxminded.javaspring.schooldb.model.Student;
import ua.foxminded.javaspring.schooldb.model.StudentAtCourse;

@TestMethodOrder(OrderAnnotation.class)
public class StudentDAOTests extends SchoolDbApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private StudentDAO studentDAO;

	@BeforeEach
	void setUp() {
		studentDAO = new StudentDAOImpl(jdbcTemplate);
	}

	private Student studentID = new Student(1L);

	@Test
	@Order(1)
	void createStudent_test() {
		Student stdnt = new Student("Maya", "Patel", 1L);
		assertThat(studentDAO.createStudent(stdnt)).isTrue();
	}

	@Test
	@Order(2)
	void getStudentById_test() {
		Optional<Student> student = studentDAO.getStudentByID(studentID);
		if (student.isPresent()) {
			Student resultStudent = student.get();
			assertThat(resultStudent).usingRecursiveComparison().isEqualTo(new Student(1L, "Maya", "Patel", "YS-27"));
		}
	}

	@Test
	@Sql(statements = "delete from studenttocourse")
	void deleteStudent_test() {
		Optional<Student> toDelete = studentDAO.getStudentByID(studentID);
		if (toDelete.isPresent()) {
			boolean isDeleted = studentDAO.deleteStudent(studentID);
			assertThat(isDeleted).isTrue();
		}
	}

	@Test
	@Order(3)
	void isValidStudentID_test() {
		assertThat(studentDAO.isValidStudentID(studentID)).isTrue();
		assertThat(studentDAO.isValidStudentID(new Student(58L))).isFalse();
	}

	@Test
	@Order(4)
	@Sql(statements = "delete from studenttocourse")
	@Sql("/TheStudentToSeveralCourses.sql")
	void listOfCoursesOfStudent_test() {
		List<StudentAtCourse> courseList = studentDAO.listOfCoursesOfStudent(studentID);
		assertNotNull(courseList);
		assertEquals(5, courseList.size());
	}
}
