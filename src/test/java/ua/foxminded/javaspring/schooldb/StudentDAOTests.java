package ua.foxminded.javaspring.schooldb;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ua.foxminded.javaspring.schooldb.dao.StudentDAO;
import ua.foxminded.javaspring.schooldb.dao.StudentDAOImpl;
import ua.foxminded.javaspring.schooldb.model.Student;

@TestMethodOrder(OrderAnnotation.class)
class StudentDAOTests extends SchoolDbApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private StudentDAO studentDAO;

	@BeforeEach
	void setUp() {
		studentDAO = new StudentDAOImpl(jdbcTemplate);
	}

	@Test
	@Order(1)
	void createStudent_test() {
		Student stdnt = new Student("Maya", "Patel", 1);
		assertThat(studentDAO.createStudent(stdnt)).isTrue();
	}

	@Test
	void getStudentByIdTest() {
		Optional<Student> student = studentDAO.getStudentById(new Student(1));
		if (student.isPresent()) {
			Student resultStudent = student.get();
			assertThat(resultStudent).usingRecursiveComparison()
					.isEqualTo(new Student(1, "Maya", "Patel", "YS-27"));
		}
	}
}
