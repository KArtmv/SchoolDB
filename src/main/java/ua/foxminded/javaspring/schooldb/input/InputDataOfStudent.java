package ua.foxminded.javaspring.schooldb.input;

import java.util.Scanner;

import ua.foxminded.javaspring.schooldb.model.Student;
import ua.foxminded.javaspring.schooldb.output.ShowListOfGroups;

public class InputDataOfStudent {

	private final ShowListOfGroups listOfGroups;
	private final InputData inputData;
	private final InputNumbers numbers;

	public InputDataOfStudent(ShowListOfGroups listOfGroups, Scanner scanner, InputData inputData,
			InputNumbers numbers) {
		this.listOfGroups = listOfGroups;
		this.inputData = inputData;
		this.numbers = numbers;
	}

	public Student inputDataOfStudent() {

		System.out.println("Enter first name of student");
		String firstName = inputData.inputData();

		System.out.println("Enter last name of student");
		String lastName = inputData.inputData();

		listOfGroups.showListOfGroups();

		System.out.println("Enter the group number for the student from the list");
		long groupId = numbers.inputNumbers();

		return new Student(firstName, lastName, groupId);
	}
}
