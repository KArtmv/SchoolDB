package ua.foxminded.javaspring.schooldb.option;

import java.util.List;

import org.springframework.stereotype.Component;

import ua.foxminded.javaspring.schooldb.dao.CourseDAO;
import ua.foxminded.javaspring.schooldb.input.InputCourseID;
import ua.foxminded.javaspring.schooldb.model.Course;
import ua.foxminded.javaspring.schooldb.model.StudentAtCourse;
import ua.foxminded.javaspring.schooldb.output.ShowCoursesList;

@Component
public class AllStudentFromCourse {

	private final CourseDAO courseDAO;
	private final ShowCoursesList listOfCourses;
	private final InputCourseID inputCourseID;

	public AllStudentFromCourse(CourseDAO courseDAO, ShowCoursesList listOfCourses, InputCourseID inputCourseID) {
		this.courseDAO = courseDAO;
		this.listOfCourses = listOfCourses;
		this.inputCourseID = inputCourseID;
	}

	public void findAllStudentsAtCourse() {
		System.out.println("Select a course from the list");

		listOfCourses.coursesList();

		Course courseID = inputCourseID.inputID();

		List<StudentAtCourse> list = courseDAO.listOfStudentsAtCourse(courseID);

		int counter = 1;

		for (StudentAtCourse studentsToCourse : list) {
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
