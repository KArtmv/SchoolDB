package ua.foxminded.javaspring.schooldb.input;

import org.springframework.stereotype.Component;

import ua.foxminded.javaspring.schooldb.dao.StudentDAO;
import ua.foxminded.javaspring.schooldb.model.Student;

@Component
public class InputStudentID {

	private final StudentDAO studentDAO;
	private final InputNumbers inputID;

	public InputStudentID(StudentDAO studentDAO, InputNumbers inputID) {
		this.studentDAO = studentDAO;
		this.inputID = inputID;
	}

	private Student studentID;

	public Student inputID() {

		boolean exist = false;

		while (!exist) {
			studentID = new Student(Long.valueOf(inputID.input()));

			if (!studentDAO.isValidStudentID(studentID)) {
				System.out.println("Invalid student ID");
			} else {
				exist = true;
			}
		}
		return studentID;
	}
}
