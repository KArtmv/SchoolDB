package ua.foxminded.javaspring.schooldb.input;

import org.springframework.stereotype.Component;

import ua.foxminded.javaspring.schooldb.model.Student;
import ua.foxminded.javaspring.schooldb.output.ShowGroupsList;

@Component
public class InputStudentData {

	private final ShowGroupsList listOfGroups;
	private final InputText inputText;
	private final InputNumbers numbers;

	public InputStudentData(ShowGroupsList listOfGroups, InputText inputData, InputNumbers numbers) {
		this.listOfGroups = listOfGroups;
		this.inputText = inputData;
		this.numbers = numbers;
	}

	public Student inputData() {

		System.out.println("Enter first name of student");
		String firstName = inputText.input();

		System.out.println("Enter last name of student");
		String lastName = inputText.input();

		listOfGroups.groupsList();

		System.out.println("Enter the group number for the student from the list");
		Long groupID = Long.valueOf(numbers.input());

		return new Student(firstName, lastName, groupID);
	}
}
