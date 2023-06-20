package ua.foxminded.javaspring.schooldb.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ua.foxminded.javaspring.schooldb.model.StudentToCourse;

public class StudentToCourseMapper implements RowMapper<StudentToCourse> {

	@Override
	public StudentToCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new StudentToCourse(
				rs.getLong("enrollment_id"),
				rs.getString("first_name"),
				rs.getString("last_name"),
				rs.getString("course_name"),
				rs.getString("course_description"));
	}
}
