package ua.foxminded.javaspring.schooldb.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ua.foxminded.javaspring.schooldb.model.StudentAtCourse;

public class StudentAtCourseMapper implements RowMapper<StudentAtCourse> {

	@Override
	public StudentAtCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new StudentAtCourse(
				rs.getLong("enrollment_id"),
				rs.getString("first_name"),
				rs.getString("last_name"),
				rs.getString("course_name"),
				rs.getString("course_description"));
	}
}
