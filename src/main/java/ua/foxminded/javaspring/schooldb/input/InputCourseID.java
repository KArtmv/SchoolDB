package ua.foxminded.javaspring.schooldb.input;

import org.springframework.stereotype.Component;

import ua.foxminded.javaspring.schooldb.dao.CourseDAO;
import ua.foxminded.javaspring.schooldb.model.Course;

@Component
public class InputCourseID {

	private final CourseDAO courseDAO;
	private final InputNumbers inputID;

	public InputCourseID(CourseDAO courseDAO, InputNumbers inputID) {
		this.courseDAO = courseDAO;
		this.inputID = inputID;
	}

	private Course courseID;

	public Course inputID() {

		boolean exist = false;

		while (!exist) {
			courseID = new Course(Long.valueOf(inputID.input()));

			if (!courseDAO.isValidCourseID(courseID)) {
				System.out.println("Invalid group ID");
			} else {
				exist = true;
			}
		}
		return courseID;
	}
}