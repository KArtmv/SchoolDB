package ua.foxminded.javaspring.schooldb.option;

import java.util.List;
import ua.foxminded.javaspring.schooldb.dao.CourseDAO;
import ua.foxminded.javaspring.schooldb.dao.StudentDAO;
import ua.foxminded.javaspring.schooldb.input.InputNumbers;
import ua.foxminded.javaspring.schooldb.input.InputStudentId;
import ua.foxminded.javaspring.schooldb.model.StudentToCourse;
import ua.foxminded.javaspring.schooldb.output.ShowListOfCoursesOfStudent;

public class DeleteStudentFromCourse {

	private final CourseDAO courseDAO;
	private final StudentDAO studentDAO;
	private final InputStudentId inputStudentId;
	private final InputNumbers numbers;
	private final ShowListOfCoursesOfStudent coursesOfStudent;

	public DeleteStudentFromCourse(CourseDAO courseDAO, StudentDAO studentDAO, InputStudentId inputStudentId,
			InputNumbers numbers, ShowListOfCoursesOfStudent coursesOfStudent) {
		this.courseDAO = courseDAO;
		this.studentDAO = studentDAO;
		this.inputStudentId = inputStudentId;
		this.numbers = numbers;
		this.coursesOfStudent = coursesOfStudent;
	}

	public void deleteFromCourse() {
		System.out.println("Enter id of student");

		List<StudentToCourse> courses = studentDAO.listOfCoursesOfStudent(inputStudentId.inputStudentId());

		coursesOfStudent.showListOfCoursesOfStudent(courses);

		System.out.println("Enter the id number of the course from which the student should be removed");

		int enrollmentId = numbers.inputNumbers();

		boolean deleted = courseDAO.deleteStudentFromTheCourse(new StudentToCourse(enrollmentId));
		if (deleted) {
			System.out.println("Student removed from course");
		}
	}
}
