package ua.foxminded.javaspring.schooldb.option;

import ua.foxminded.javaspring.schooldb.dao.CourseDAO;
import ua.foxminded.javaspring.schooldb.input.InputNumbers;
import ua.foxminded.javaspring.schooldb.input.InputStudentId;
import ua.foxminded.javaspring.schooldb.model.Course;
import ua.foxminded.javaspring.schooldb.model.Student;
import ua.foxminded.javaspring.schooldb.output.ShowListOfCourses;

public class AddStudentToCourse {

	private final CourseDAO сourseDAO;
	private final ShowListOfCourses listOfCourses;
	private final InputStudentId insertStudentId;
	private final InputNumbers inputNumbers;

	public AddStudentToCourse(CourseDAO сourseDAO, ShowListOfCourses listOfCourses, InputStudentId insertStudentId,
			InputNumbers inputNumbers) {
		this.сourseDAO = сourseDAO;
		this.listOfCourses = listOfCourses;
		this.insertStudentId = insertStudentId;
		this.inputNumbers = inputNumbers;
	}

	public void addStudentToCourse() {
		System.out.println("Enter the ID of the student you want to add to the course");
		Student studentId = insertStudentId.inputStudentId();

		listOfCourses.showListofCourses();

		System.out.println("select the course you want to add the student to");
		int courseId = inputNumbers.inputNumbers();

		boolean added = сourseDAO.addStudentAtCourse(studentId, new Course(courseId));

		if (added) {
			System.out.println("Student have been added at course");
		}
	}
}
