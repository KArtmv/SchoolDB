package ua.foxminded.javaspring.schooldb.option;

import java.util.List;
import ua.foxminded.javaspring.schooldb.dao.GroupDAO;
import ua.foxminded.javaspring.schooldb.input.InputNumbers;
import ua.foxminded.javaspring.schooldb.model.CountStudentsAtGroup;

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

		List<CountStudentsAtGroup> list = groupDAO.counterStudentsAtGroups(count);

		for (CountStudentsAtGroup course : list) {
			int countAtGroup = course.getCount();
			String groupName = course.getGroupName();

			System.out.println(String.format("%d students at group: %s.", countAtGroup, groupName));
		}
	}
}
