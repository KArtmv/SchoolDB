package ua.foxminded.javaspring.schooldb.option;

import org.springframework.stereotype.Component;

import ua.foxminded.javaspring.schooldb.dao.CourseDAO;
import ua.foxminded.javaspring.schooldb.input.InputNumbers;
import ua.foxminded.javaspring.schooldb.input.InputStudentID;
import ua.foxminded.javaspring.schooldb.model.Course;
import ua.foxminded.javaspring.schooldb.model.Student;
import ua.foxminded.javaspring.schooldb.output.ShowCoursesList;

@Component
public class AddStudentToCourse {

	private final CourseDAO сourseDAO;
	private final ShowCoursesList coursesList;
	private final InputStudentID inputStudentID;
	private final InputNumbers number;

	public AddStudentToCourse(CourseDAO сourseDAO, ShowCoursesList coursesList, InputStudentID inputStudentID,
			InputNumbers number) {
		this.сourseDAO = сourseDAO;
		this.coursesList = coursesList;
		this.inputStudentID = inputStudentID;
		this.number = number;
	}

	public void addStudentToCourse() {
		System.out.println("Enter the student ID you want to add to the course");
		Student studentID = inputStudentID.inputID();

		coursesList.coursesList();

		System.out.println("Select the course you want to add the student.");

		Course inputCourseID = new Course(Long.valueOf(number.input()));

		boolean added = сourseDAO.addStudentToCourse(studentID, inputCourseID);

		if (added) {
			System.out.println("Student have been added at course");
		}
	}
}
