package ua.foxminded.javaspring.schooldb.dao;

import java.sql.ResultSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.foxminded.javaspring.schooldb.model.CountStudentsAtGroup;
import ua.foxminded.javaspring.schooldb.model.Group;
import ua.foxminded.javaspring.schooldb.rowmapper.CountStudentsAtGroupMapper;
import ua.foxminded.javaspring.schooldb.rowmapper.GroupMapper;

@Repository
public class GroupDAOimpl implements GroupDAO {
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public GroupDAOimpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private final String SQL_CHECK_IS_GROUP_EXIST = "select group_id from groups where group_id = ?";
	private final String SQL_GET_ALL = "select * from groups";
	private final String SQL_GET_GROUP_BY_COUNT = "SELECT g.group_id, g.group_name, COUNT(s.student_id) AS student_count\n"
			+ "FROM groups g\n"
			+ "LEFT JOIN students s ON g.group_id = s.group_id\n" 
			+ "GROUP BY g.group_id\n"
			+ "HAVING COUNT(s.student_id) <=?";

	private final GroupMapper mapper = new GroupMapper();
	private final CountStudentsAtGroupMapper countMapper = new CountStudentsAtGroupMapper();

	@Override
	public List<Group> listOfGroups() {
		return jdbcTemplate.query(SQL_GET_ALL, mapper);
	}

	@Override
	public List<CountStudentsAtGroup> counterStudentsAtGroups(int count) {
		return jdbcTemplate.query(SQL_GET_GROUP_BY_COUNT, countMapper, count);
	}
	
	@Override
	public boolean isValidGroupID(Group groupID) {
		return jdbcTemplate.query(SQL_CHECK_IS_GROUP_EXIST, ResultSet::next, groupID.getGroupID());
	}
}
