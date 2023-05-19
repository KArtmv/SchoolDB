package ua.foxminded.javaspring.schooldb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.foxminded.javaspring.schooldb.model.Course;
import ua.foxminded.javaspring.schooldb.model.Student;
import ua.foxminded.javaspring.schooldb.model.StudentToCourse;
import ua.foxminded.javaspring.schooldb.rowmapper.CourseMapper;
import ua.foxminded.javaspring.schooldb.rowmapper.StudentToCourseMapper;

@Repository
public class CourseDAOImpl implements CourseDAO {
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public CourseDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private final String SQL_GET_ALL = "select * from courses";
	private final String SQL_GET_LIST_STUDENTS_AT_COURSE = "select *\n"
			+ "from students s\n" 
			+ "join studenttocourse st on s.student_id = st.student_id\n"
			+ "join courses c on st.course_id = c.course_id\n" 
			+ "where c.course_id=?";
	private final String SQL_DELETE_STUDENT_FROM_COURSES = "delete from studenttocourse where student_id =?";
	private final String SQL_ADD_STUDENTS_AT_COURSE = "INSERT INTO studenttocourse (student_id, course_id) VALUES (?, ?)";
	private final String SQL_DELETE_STUDENT_FROM_THE_COURSE = "delete from studenttocourse where enrollment_id = ?";

	CourseMapper mapper = new CourseMapper();
	StudentToCourseMapper toCourseMapper = new StudentToCourseMapper();

	@Override
	public List<Course> listOfCourse() {
		return jdbcTemplate.query(SQL_GET_ALL, mapper);
	}

	@Override
	public List<StudentToCourse> listOfStudentsAtCourse(Course courseId) {
		return jdbcTemplate.query(SQL_GET_LIST_STUDENTS_AT_COURSE, toCourseMapper, courseId.getCourseId());
	}

	@Override
	public boolean deleteStudentFromTheirAllCourses(Student studentId) {
		return jdbcTemplate.update(SQL_DELETE_STUDENT_FROM_COURSES, studentId.getStudentId()) > 0;
	}

	@Override
	public boolean addStudentAtCourse(Student studentId, Course courseId) {
		return jdbcTemplate.update(SQL_ADD_STUDENTS_AT_COURSE, studentId.getStudentId(), courseId.getCourseId()) > 0;
	}

	@Override
	public boolean deleteStudentFromTheCourse(StudentToCourse enrollmenId) {
		return jdbcTemplate.update(SQL_DELETE_STUDENT_FROM_THE_COURSE, enrollmenId.getEnrollmentId()) > 0;
	}
}
