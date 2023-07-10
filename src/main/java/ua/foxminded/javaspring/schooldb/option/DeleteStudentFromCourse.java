package ua.foxminded.javaspring.schooldb.option;

import java.util.List;

import org.springframework.stereotype.Component;

import ua.foxminded.javaspring.schooldb.dao.CourseDAO;
import ua.foxminded.javaspring.schooldb.dao.StudentDAO;
import ua.foxminded.javaspring.schooldb.input.InputNumbers;
import ua.foxminded.javaspring.schooldb.input.InputStudentID;
import ua.foxminded.javaspring.schooldb.model.Student;
import ua.foxminded.javaspring.schooldb.model.StudentAtCourse;
import ua.foxminded.javaspring.schooldb.output.ShowStudentCourses;

@Component
public class DeleteStudentFromCourse {

	private final CourseDAO courseDAO;
	private final StudentDAO studentDAO;
	private final InputStudentID inputStudentID;
	private final InputNumbers numbers;
	private final ShowStudentCourses coursesOfStudent;

	public DeleteStudentFromCourse(CourseDAO courseDAO, StudentDAO studentDAO, InputStudentID inputStudentID,
			InputNumbers numbers, ShowStudentCourses coursesOfStudent) {
		this.courseDAO = courseDAO;
		this.studentDAO = studentDAO;
		this.inputStudentID = inputStudentID;
		this.numbers = numbers;
		this.coursesOfStudent = coursesOfStudent;
	}

	public void deleteFromCourse() {
		System.out.println("Enter student ID");
		Student inputID = inputStudentID.inputID();

		List<StudentAtCourse> courses = studentDAO.listOfCoursesOfStudent(inputID);
		coursesOfStudent.coursesList(courses);

		System.out.println("Enter the course ID from which the student should be removed");

		StudentAtCourse inputCourseID = new StudentAtCourse(Long.valueOf(numbers.input()));
		boolean deleted = courseDAO.deleteStudentFromTheCourse(inputCourseID);

		if (deleted) {
			System.out.println("Student removed from course");
		}
	}
}
