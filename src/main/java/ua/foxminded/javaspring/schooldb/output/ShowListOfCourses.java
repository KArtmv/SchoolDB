package ua.foxminded.javaspring.schooldb.output;

import ua.foxminded.javaspring.schooldb.dao.CourseDAO;
import ua.foxminded.javaspring.schooldb.model.Course;

public class ShowListOfCourses {

	private final CourseDAO courseDAO;

	public ShowListOfCourses(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public void showListofCourses() {

		for (Course course : courseDAO.listOfCourse()) {
			long courseId = course.getCourseId();
			String courseName = course.getCourseName();
			String courseDescription = course.getCourseDescription();
			System.out.println(String.format("%d. Course- %s.", courseId, courseName));
			System.out.println(String.format(" Description- %s.", courseDescription));
			System.out.println();
		}
	}
}
