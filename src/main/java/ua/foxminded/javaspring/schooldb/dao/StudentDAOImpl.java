package ua.foxminded.javaspring.schooldb.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ua.foxminded.javaspring.schooldb.model.Student;
import ua.foxminded.javaspring.schooldb.model.StudentToCourse;
import ua.foxminded.javaspring.schooldb.rowmapper.StudentMapper;
import ua.foxminded.javaspring.schooldb.rowmapper.StudentToCourseMapper;

@Component
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private final JdbcTemplate jdbcTemplate;

	private final String SQL_DELETE_STUDENT = "delete from students where student_id=?";
	private final String SQL_FIND_STUDENT_BY_ID = "select * from students where student_id=?";
	private final String SQL_ADD_NEW_STUDENT = "insert into students (first_name, last_name, group_id) values (?, ?, ?)";
	private final String SQL_CHECK_IS_STUDENT_EXIST = "select student_id from students where student_id = ?";
	private final String SQL_COURSES_OF_STUDENT = "select sc.enrollment_id, s.first_name, s.last_name, c.course_name, c.course_description\n"
			+ "from students s join studenttocourse sc on s.student_id = sc.student_id\n"
			+ "join courses c on sc.course_id = c.course_id\n" 
			+ "where s.student_id=?";

	private final RowMapper<Student> mapper = new StudentMapper();
	private final RowMapper<StudentToCourse> courseMapper = new StudentToCourseMapper();

	@Autowired
	public StudentDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Student getStudentById(Student studentId) {
		List<Student> students = jdbcTemplate.query(SQL_FIND_STUDENT_BY_ID, mapper, studentId.getStudentId());
		return students.isEmpty() ? null : students.get(0);
	}

	@Override
	public boolean deleteStudent(Student student) {
		return jdbcTemplate.update(SQL_DELETE_STUDENT, student.getStudentId()) > 0;
	}

	@Override
	public boolean createStudent(Student student) {
		return jdbcTemplate.update(SQL_ADD_NEW_STUDENT, student.getFirstName(), student.getLastrName(),
				student.getGroupId()) > 0;
	}

	@Override
	public boolean isValidStudentId(Student studentId) {
		return jdbcTemplate.query(SQL_CHECK_IS_STUDENT_EXIST, ResultSet::next, studentId.getStudentId());
	}

	@Override
	public List<StudentToCourse> listOfCoursesOfStudent(Student studentId) {
		return jdbcTemplate.query(SQL_COURSES_OF_STUDENT, courseMapper, studentId.getStudentId());
	}
}
