package ua.foxminded.javaspring.schooldb.output;

import org.springframework.stereotype.Component;

import ua.foxminded.javaspring.schooldb.dao.CourseDAO;
import ua.foxminded.javaspring.schooldb.model.Course;

@Component
public class ShowCoursesList {

	private final CourseDAO courseDAO;

	public ShowCoursesList(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public void coursesList() {

		for (Course course : courseDAO.listOfCourse()) {
			Long courseID = course.getCourseID();
			String courseName = course.getCourseName();
			String courseDescription = course.getCourseDescription();
			System.out.println(String.format("%d. Course- %s.", courseID, courseName));
			System.out.println(String.format(" Description- %s.", courseDescription));
			System.out.println();
		}
	}
}
