package ua.foxminded.javaspring.schooldb.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import ua.foxminded.javaspring.schooldb.SchoolDbApplicationTests;
import ua.foxminded.javaspring.schooldb.model.CountStudentsAtGroup;
import ua.foxminded.javaspring.schooldb.model.Group;

public class GroupDAOTests extends SchoolDbApplicationTests {

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

	@Sql("/StudentData.sql")
	@Test
	void countStudentsAtGroup() {
		List<CountStudentsAtGroup> expect = new ArrayList<>();
		expect.add(new CountStudentsAtGroup(0, "Students without group"));
		expect.add(new CountStudentsAtGroup(0, "TC-63"));
		expect.add(new CountStudentsAtGroup(0, "QM-09"));
		expect.add(new CountStudentsAtGroup(3, "YS-27"));
		expect.add(new CountStudentsAtGroup(1, "PL-41"));
		expect.add(new CountStudentsAtGroup(0, "ZF-83"));
		expect.add(new CountStudentsAtGroup(5, "HV-14"));
		expect.add(new CountStudentsAtGroup(0, "KX-76"));
		expect.add(new CountStudentsAtGroup(0, "ND-98"));
		expect.add(new CountStudentsAtGroup(0, "WU-48"));

		List<CountStudentsAtGroup> groupList = groupDAO.counterStudentsAtGroups(5);
		assertThat(groupList).usingRecursiveFieldByFieldElementComparatorOnFields("countStudents", "groupName")
				.containsExactlyInAnyOrderElementsOf(groupList);
	}
}
