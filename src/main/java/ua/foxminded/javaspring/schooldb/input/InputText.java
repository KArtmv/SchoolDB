package ua.foxminded.javaspring.schooldb.input;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class InputText {

	private final Scanner scanner;

	public InputText(Scanner scanner) {
		this.scanner = scanner;
	}

	public String input() {
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
