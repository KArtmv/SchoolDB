package ua.foxminded.javaspring.schooldb.input;

import org.springframework.stereotype.Component;

import ua.foxminded.javaspring.schooldb.model.Group;
import ua.foxminded.javaspring.schooldb.model.Student;
import ua.foxminded.javaspring.schooldb.output.ShowGroupsList;

@Component
public class InputStudentData {

	private final ShowGroupsList listOfGroups;
	private final InputText inputText;
	private final InputGroupID inputGroupID;

	public InputStudentData(ShowGroupsList listOfGroups, InputText inputData, InputGroupID inputGroupID) {
		this.listOfGroups = listOfGroups;
		this.inputText = inputData;
		this.inputGroupID = inputGroupID;
	}

	public Student inputData() {

		System.out.println("Enter first name of student");
		String firstName = inputText.input();

		System.out.println("Enter last name of student");
		String lastName = inputText.input();

		listOfGroups.groupsList();

		System.out.println("Enter the group number for the student from the list");
		Group groupID = inputGroupID.inputID();

		return new Student(firstName, lastName, groupID.getGroupID());
	}
}
