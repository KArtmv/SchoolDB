package ua.foxminded.javaspring.schooldb.option;

import org.springframework.stereotype.Component;

import ua.foxminded.javaspring.schooldb.dao.CourseDAO;
import ua.foxminded.javaspring.schooldb.dao.StudentDAO;
import ua.foxminded.javaspring.schooldb.input.InputStudentID;
import ua.foxminded.javaspring.schooldb.model.Student;

@Component
public class DeleteStudent {

	private final StudentDAO studentDAO;
	private final InputStudentID inputStudentID;
	private final CourseDAO courseDAO;

	public DeleteStudent(StudentDAO studentDAO, InputStudentID inputStudentID, CourseDAO courseDAO) {
		this.studentDAO = studentDAO;
		this.inputStudentID = inputStudentID;
		this.courseDAO = courseDAO;
	}

	public void deleteStudent() {
		System.out.println("Enter the ID of the student to be removed");

		Student inputID = inputStudentID.inputID();

		boolean deleteFromCourses = courseDAO.deleteStudentFromTheirAllCourses(inputID);
		if (deleteFromCourses) {
			System.out.println("student is deleted from the all their courses");

			boolean deleted = studentDAO.deleteStudent(inputID);
			if (deleted) {
				System.out.println("Student is deleted");
			}
		}
	}
}
