package ua.foxminded.javaspring.schooldb.output;

import java.util.List;

import org.springframework.stereotype.Component;

import ua.foxminded.javaspring.schooldb.model.StudentAtCourse;

@Component
public class ShowStudentCourses {

	public void coursesList(List<StudentAtCourse> courses) {
		int couter = 0;

		for (StudentAtCourse course : courses) {
			Long enrollmentID = course.getEnrollmentID();
			String firstName = course.getFirstName();
			String lastName = course.getLastName();
			String courseName = course.getCourseName();
			String courseDescription = course.getCourseDescription();
			if (couter == 0) {
				System.out.println(String.format("List of courses of %s %s", firstName, lastName));
			}
			System.out.println(String.format("%d. %s. Description: %s", enrollmentID, courseName, courseDescription));
			couter++;
		}
	}
}
