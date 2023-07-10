package ua.foxminded.javaspring.schooldb.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ua.foxminded.javaspring.schooldb.model.CountStudentsAtGroup;

public class CountStudentsAtGroupMapper implements RowMapper<CountStudentsAtGroup> {

	@Override
	public CountStudentsAtGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new CountStudentsAtGroup(rs.getInt("student_count"), rs.getString("group_name"));
	}
}
