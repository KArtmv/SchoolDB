package ua.foxminded.javaspring.schooldb.option;

import java.util.List;
import java.util.Map;
import ua.foxminded.javaspring.schooldb.dao.GroupDAO;
import ua.foxminded.javaspring.schooldb.input.InputNumbers;

public class StudentCountGroupFinder {

	private final GroupDAO groupDAO;
	private final InputNumbers numbers;

	public StudentCountGroupFinder(GroupDAO groupDAO, InputNumbers numbers) {
		this.groupDAO = groupDAO;
		this.numbers = numbers;
	}

	public void groupFinder() {
		System.out.println("Enter count of students at group");

		int count = numbers.inputNumbers();

		List<Map<String, Object>> list = groupDAO.counterStudentsAtGroups(count);

		for (Map<String, Object> map : list) {
			String groupName = map.get("group_name").toString();
			int countAtGroup = Integer.parseInt(map.get("student_count").toString());

			System.out.println(String.format("%d students at group: %s", countAtGroup, groupName));
		}
	}
}
