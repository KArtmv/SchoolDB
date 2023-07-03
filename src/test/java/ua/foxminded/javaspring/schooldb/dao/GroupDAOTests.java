package ua.foxminded.javaspring.schooldb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import ua.foxminded.javaspring.schooldb.dao.GroupDAO;
import ua.foxminded.javaspring.schooldb.dao.GroupDAOimpl;
import ua.foxminded.javaspring.schooldb.model.Group;

class GroupDAOTests extends SchoolDbApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private GroupDAO groupDAO;

	@BeforeEach
	void setUp() {
		groupDAO = new GroupDAOimpl(jdbcTemplate);
	}

	@Test
	void listOfGroupsTest() {
		List<Group> groupList = groupDAO.listOfGroups();
		assertEquals(11, groupList.size());
	}

}
