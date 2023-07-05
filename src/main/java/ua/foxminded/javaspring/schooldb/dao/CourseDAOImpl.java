package ua.foxminded.javaspring.schooldb.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.foxminded.javaspring.schooldb.model.Course;
import ua.foxminded.javaspring.schooldb.model.Student;
import ua.foxminded.javaspring.schooldb.model.StudentAtCourse;
import ua.foxminded.javaspring.schooldb.rowmapper.CourseMapper;
import ua.foxminded.javaspring.schooldb.rowmapper.StudentAtCourseMapper;

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
	private final String SQL_CHECK_IS_COURSE_EXIST = "select course_id from courses where course_id = ?";


	CourseMapper mapper = new CourseMapper();
	StudentAtCourseMapper toCourseMapper = new StudentAtCourseMapper();

	@Override
	public List<Course> listOfCourse() {
		return jdbcTemplate.query(SQL_GET_ALL, mapper);
	}

	@Override
	public List<StudentAtCourse> listOfStudentsAtCourse(Course courseID) {
		return jdbcTemplate.query(SQL_GET_LIST_STUDENTS_AT_COURSE, toCourseMapper, courseID.getCourseID());
	}

	@Override
	public boolean deleteStudentFromTheirAllCourses(Student studentID) {
		return jdbcTemplate.update(SQL_DELETE_STUDENT_FROM_COURSES, studentID.getStudentID()) > 0;
	}

	@Override
	public boolean addStudentToCourse(Student studentID, Course courseID) {
		return jdbcTemplate.update(SQL_ADD_STUDENTS_AT_COURSE, studentID.getStudentID(), courseID.getCourseID()) > 0;
	}

	@Override
	public boolean deleteStudentFromTheCourse(StudentAtCourse enrollmenID) {
		return jdbcTemplate.update(SQL_DELETE_STUDENT_FROM_THE_COURSE, enrollmenID.getEnrollmentID()) > 0;
	}

	@Override
	public boolean isValidCourseID(Course courseID) {
		return jdbcTemplate.query(SQL_CHECK_IS_COURSE_EXIST, ResultSet::next, courseID.getCourseID());
	}
}
