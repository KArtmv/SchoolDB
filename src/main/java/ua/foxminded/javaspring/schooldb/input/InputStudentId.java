package ua.foxminded.javaspring.schooldb.input;

import ua.foxminded.javaspring.schooldb.dao.StudentDAO;
import ua.foxminded.javaspring.schooldb.model.Student;

public class InputStudentId {

	private final StudentDAO studentDAO;
	private final InputNumbers inputNumbers;

	public InputStudentId(StudentDAO studentDAO, InputNumbers inputNumbers) {
		this.studentDAO = studentDAO;
		this.inputNumbers = inputNumbers;
	}

	private Student studentId;

	public Student inputStudentId() {

		boolean exist = false;

		while (!exist) {
			studentId = new Student(inputNumbers.inputNumbers());

			if (!studentDAO.isValidStudentId(studentId)) {
				System.out.println("Invalid student ID");
			} else {
				exist = true;
			}
		}
		return studentId;
	}
}
