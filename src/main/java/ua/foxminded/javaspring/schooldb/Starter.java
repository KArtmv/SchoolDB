package ua.foxminded.javaspring.schooldb;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ua.foxminded.javaspring.schooldb.dao.CourseDAO;
import ua.foxminded.javaspring.schooldb.dao.GroupDAO;
import ua.foxminded.javaspring.schooldb.dao.StudentDAO;
import ua.foxminded.javaspring.schooldb.input.InputData;
import ua.foxminded.javaspring.schooldb.input.InputDataOfStudent;
import ua.foxminded.javaspring.schooldb.input.InputNumbers;
import ua.foxminded.javaspring.schooldb.input.InputStudentId;
import ua.foxminded.javaspring.schooldb.option.AddStudent;
import ua.foxminded.javaspring.schooldb.option.AddStudentToCourse;
import ua.foxminded.javaspring.schooldb.option.AllStudentFromCourse;
import ua.foxminded.javaspring.schooldb.option.DeleteStudent;
import ua.foxminded.javaspring.schooldb.option.DeleteStudentFromCourse;
import ua.foxminded.javaspring.schooldb.option.StudentCountGroupFinder;
import ua.foxminded.javaspring.schooldb.output.ShowListOfCourses;
import ua.foxminded.javaspring.schooldb.output.ShowListOfCoursesOfStudent;
import ua.foxminded.javaspring.schooldb.output.ShowListOfGroups;

public class Starter {

	private final AnnotationConfigApplicationContext contex;

	public Starter(AnnotationConfigApplicationContext contex) {
		this.contex = contex;
	}

	public void appStart() {
		StudentDAO studentDAO = contex.getBean(StudentDAO.class);
		GroupDAO groupDAO = contex.getBean(GroupDAO.class);
		CourseDAO courseDAO = contex.getBean(CourseDAO.class);

		Scanner scanner = new Scanner(System.in);
		InputNumbers numbers = new InputNumbers(scanner);
		InputData inputData = new InputData(scanner);
		InputStudentId inputStudentId = new InputStudentId(studentDAO, numbers);

		ShowListOfCoursesOfStudent coursesOfStudent = new ShowListOfCoursesOfStudent();
		ShowListOfCourses listOfCourses = new ShowListOfCourses(courseDAO);
		ShowListOfGroups listOfGroups = new ShowListOfGroups(groupDAO);

		StudentCountGroupFinder countGroupFinder = new StudentCountGroupFinder(groupDAO, numbers);
		DeleteStudent deleteStudent = new DeleteStudent(studentDAO, inputStudentId, courseDAO);
		AllStudentFromCourse studentFromCourse = new AllStudentFromCourse(courseDAO, listOfCourses, numbers);
		DeleteStudentFromCourse deleteStudentFromCourse = new DeleteStudentFromCourse(courseDAO, studentDAO,
				inputStudentId, numbers, coursesOfStudent);
		AddStudentToCourse studentToCourse = new AddStudentToCourse(courseDAO, listOfCourses, inputStudentId, numbers);
		InputDataOfStudent dataOfStudent = new InputDataOfStudent(listOfGroups, scanner, inputData, numbers);
		AddStudent addStudent = new AddStudent(studentDAO, dataOfStudent);

		SwitchOfMenu switchOfMenu = new SwitchOfMenu(scanner, countGroupFinder, studentFromCourse, addStudent,
				deleteStudent, studentToCourse, deleteStudentFromCourse);

		boolean exit = false;
		StartMenu startMenu = new StartMenu();
		startMenu.startMenu();

		while (!exit) {
			exit = switchOfMenu.switchOfMenu(exit, startMenu);
		}
	}
}
