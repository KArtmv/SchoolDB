package ua.foxminded.javaspring.schooldb.option;

import ua.foxminded.javaspring.schooldb.dao.CourseDAO;
import ua.foxminded.javaspring.schooldb.dao.StudentDAO;
import ua.foxminded.javaspring.schooldb.input.InputStudentId;
import ua.foxminded.javaspring.schooldb.model.Student;

public class DeleteStudent {

	private final StudentDAO studentDAO;
	private final InputStudentId inputStudentId;
	private final CourseDAO courseDAO;

	public DeleteStudent(StudentDAO studentDAO, InputStudentId inputStudentId, CourseDAO courseDAO) {
		this.studentDAO = studentDAO;
		this.inputStudentId = inputStudentId;
		this.courseDAO = courseDAO;
	}

	public void deleteStudent() {
		System.out.println("Enter the ID of the student to be removed");

		Student inputId = inputStudentId.inputStudentId();

		boolean deleteFromCourses = courseDAO.deleteStudentFromTheirAllCourses(inputId);
		if (deleteFromCourses) {
			System.out.println("student deleted from the all their courses");

			boolean deleted = studentDAO.deleteStudent(inputId);
			if (deleted) {
				System.out.println("student deleted");
			}
		}
	}
}
