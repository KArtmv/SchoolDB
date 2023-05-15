package ua.foxminded.javaspring.schooldb.option;

import java.util.List;
import ua.foxminded.javaspring.schooldb.dao.CourseDAO;
import ua.foxminded.javaspring.schooldb.input.InputNumbers;
import ua.foxminded.javaspring.schooldb.model.Course;
import ua.foxminded.javaspring.schooldb.model.StudentToCourse;
import ua.foxminded.javaspring.schooldb.output.ShowListOfCourses;

public class AllStudentFromCourse {

	private final CourseDAO courseDAO;
	private final ShowListOfCourses listOfCourses;
	private final InputNumbers inputNumbers;

	public AllStudentFromCourse(CourseDAO courseDAO, ShowListOfCourses listOfCourses, InputNumbers inputNumbers) {
		this.courseDAO = courseDAO;
		this.listOfCourses = listOfCourses;
		this.inputNumbers = inputNumbers;
	}

	public void findAllStudentsAtCourse() {
		System.out.println("Select a course from the list");

		listOfCourses.showListofCourses();

		int inputNumber = inputNumbers.inputNumbers();

		List<StudentToCourse> list = courseDAO.listOfStudentsAtCourse(new Course(inputNumber));

		int counter = 1;

		for (StudentToCourse studentsToCourse : list) {
			String firstName = studentsToCourse.getFirstName();
			String lastName = studentsToCourse.getLastName();
			String courseName = studentsToCourse.getCourseName();
			String courseDescription = studentsToCourse.getCourseDescription();

			if (counter == 1) {
				System.out.println("Course: " + courseName);
				System.out.println("Description: " + courseDescription);
			}
			System.out.println(String.format("%d. %s %s", counter, firstName, lastName));
			counter++;
		}
	}
}
