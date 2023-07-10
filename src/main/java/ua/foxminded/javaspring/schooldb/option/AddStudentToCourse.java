package ua.foxminded.javaspring.schooldb.option;

import org.springframework.stereotype.Component;

import ua.foxminded.javaspring.schooldb.dao.CourseDAO;
import ua.foxminded.javaspring.schooldb.input.InputCourseID;
import ua.foxminded.javaspring.schooldb.input.InputStudentID;
import ua.foxminded.javaspring.schooldb.model.Course;
import ua.foxminded.javaspring.schooldb.model.Student;
import ua.foxminded.javaspring.schooldb.output.ShowCoursesList;

@Component
public class AddStudentToCourse {

	private final CourseDAO сourseDAO;
	private final ShowCoursesList coursesList;
	private final InputStudentID inputStudentID;
	private final InputCourseID inputCourseID;

	public AddStudentToCourse(CourseDAO сourseDAO, ShowCoursesList coursesList, InputStudentID inputStudentID,
			InputCourseID inputCourseID) {
		this.сourseDAO = сourseDAO;
		this.coursesList = coursesList;
		this.inputStudentID = inputStudentID;
		this.inputCourseID = inputCourseID;
	}

	public void addStudentToCourse() {
		System.out.println("Enter the student ID you want to add to the course");
		Student studentID = inputStudentID.inputID();

		coursesList.coursesList();

		System.out.println("Select the course you want to add the student.");

		Course courseID = inputCourseID.inputID();

		boolean added = сourseDAO.addStudentToCourse(studentID, courseID);

		if (added) {
			System.out.println("Student have been added at course");
		}
	}
}
