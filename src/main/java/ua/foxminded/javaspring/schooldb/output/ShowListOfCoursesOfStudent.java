package ua.foxminded.javaspring.schooldb.output;

import java.util.List;

import ua.foxminded.javaspring.schooldb.model.StudentToCourse;

public class ShowListOfCoursesOfStudent {

	public void showListOfCoursesOfStudent(List<StudentToCourse> courses) {
		int couter = 0;

		for (StudentToCourse course : courses) {
			long enrollmentId = course.getEnrollmentId();
			String firstName = course.getFirstName();
			String lastName = course.getLastName();
			String courseName = course.getCourseName();
			String courseDescription = course.getCourseDescription();
			if (couter == 0) {
				System.out.println(String.format("List of courses of %s %s", firstName, lastName));
			}
			System.out.println(String.format("%d. %s. Description: %s", enrollmentId, courseName, courseDescription));
			couter++;
		}
	}
}
