package ua.foxminded.javaspring.schooldb.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ua.foxminded.javaspring.schooldb.model.Groupe;

public class GroupMapper implements RowMapper<Groupe> {

	@Override
	public Groupe mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new Groupe(rs.getLong("group_id"), rs.getString("group_name"));
	}

}
