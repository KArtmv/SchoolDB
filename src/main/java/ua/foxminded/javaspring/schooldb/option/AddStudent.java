package ua.foxminded.javaspring.schooldb.option;

import ua.foxminded.javaspring.schooldb.dao.StudentDAO;
import ua.foxminded.javaspring.schooldb.input.InputDataOfStudent;
import ua.foxminded.javaspring.schooldb.model.Student;

public class AddStudent {

	private final StudentDAO studentDAO;
	private final InputDataOfStudent dataOfstudent;

	public AddStudent(StudentDAO studentDAO, InputDataOfStudent dataOfstudent) {
		this.studentDAO = studentDAO;
		this.dataOfstudent = dataOfstudent;
	}

	public void addStudent() {
		Student student = dataOfstudent.inputDataOfStudent();

		boolean added = studentDAO.createStudent(student);

		if (added) {
			System.out.println("Student have been added to database");
		}
	}
}
