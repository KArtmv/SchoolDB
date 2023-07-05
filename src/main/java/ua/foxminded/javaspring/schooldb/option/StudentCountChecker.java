package ua.foxminded.javaspring.schooldb.option;

import java.util.List;

import org.springframework.stereotype.Component;

import ua.foxminded.javaspring.schooldb.dao.GroupDAO;
import ua.foxminded.javaspring.schooldb.input.InputNumbers;
import ua.foxminded.javaspring.schooldb.model.CountStudentsAtGroup;

@Component
public class StudentCountChecker {

	private final GroupDAO groupDAO;
	private final InputNumbers numbers;

	public StudentCountChecker(GroupDAO groupDAO, InputNumbers numbers) {
		this.groupDAO = groupDAO;
		this.numbers = numbers;
	}

	public void checkByCount() {
		System.out.println("Enter count of students at group");

		int inputCount = numbers.input();
		List<CountStudentsAtGroup> list = groupDAO.counterStudentsAtGroups(inputCount);

		for (CountStudentsAtGroup group : list) {
			int countAtGroup = group.getCount();
			String groupName = group.getGroupName();

			System.out.println(String.format("%d students at group: %s.", countAtGroup, groupName));
		}
	}
}
