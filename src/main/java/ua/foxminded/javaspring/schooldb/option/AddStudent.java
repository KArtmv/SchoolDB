package ua.foxminded.javaspring.schooldb.option;

import org.springframework.stereotype.Component;

import ua.foxminded.javaspring.schooldb.dao.StudentDAO;
import ua.foxminded.javaspring.schooldb.input.InputStudentData;
import ua.foxminded.javaspring.schooldb.model.Student;

@Component
public class AddStudent {

	private final StudentDAO studentDAO;
	private final InputStudentData dataOfstudent;

	public AddStudent(StudentDAO studentDAO, InputStudentData dataOfstudent) {
		this.studentDAO = studentDAO;
		this.dataOfstudent = dataOfstudent;
	}

	public void addStudent() {
		Student student = dataOfstudent.inputData();

		boolean added = studentDAO.createStudent(student);

		if (added) {
			System.out.println("Student have been added to database");
		}
	}
}
