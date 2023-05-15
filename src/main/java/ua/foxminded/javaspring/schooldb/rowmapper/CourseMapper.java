package ua.foxminded.javaspring.schooldb.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ua.foxminded.javaspring.schooldb.model.Course;

public class CourseMapper implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new Course(rs.getLong("course_id"),
				rs.getString("course_name"),
				rs.getString("course_description"));
	}

}
