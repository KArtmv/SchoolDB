package ua.foxminded.javaspring.schooldb.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import ua.foxminded.javaspring.schooldb.model.Group;
import ua.foxminded.javaspring.schooldb.rowmapper.GroupMapper;

@Component
public class GroupDAOimpl implements GroupDAO {

	@Autowired
	private final JdbcTemplate jdbcTemplate;

	private final String SQL_GET_ALL = "select * from groups";
	private final String SQL_GET_GROUP_BY_COUNT = "SELECT g.group_id, g.group_name, COUNT(s.student_id) AS student_count\n"
			+ "FROM groups g\n" + "LEFT JOIN students s ON g.group_id = s.group_id\n" 
			+ "GROUP BY g.group_id\n"
			+ "HAVING COUNT(s.student_id) <=?";

	private final GroupMapper mapper = new GroupMapper();

	@Autowired
	public GroupDAOimpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Group> listOfGroups() {
		return jdbcTemplate.query(SQL_GET_ALL, mapper);
	}

	@Override
	public List<Map<String, Object>> counterStudentsAtGroups(int count) {
		return jdbcTemplate.queryForList(SQL_GET_GROUP_BY_COUNT, count);
	}
}
