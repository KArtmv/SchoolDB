package ua.foxminded.javaspring.schooldb.input;

import java.util.Scanner;

public class InputData {

	private final Scanner scanner;

	public InputData(Scanner scanner) {
		this.scanner = scanner;
	}

	public String inputData() {
		boolean isTextCorrect = false;

		String input = "";

		while (!isTextCorrect) {
			input = scanner.nextLine();
			if (input == null || input.equals("") || input.matches("\\s+") || input.matches("[^a-zA-Z]+")) {
				System.out.println("Illegal Argument try again");
			} else {
				isTextCorrect = true;
			}
		}
		return input;
	}
}
