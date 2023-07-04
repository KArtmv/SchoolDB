package ua.foxminded.javaspring.schooldb;

import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import ua.foxminded.javaspring.schooldb.option.AddStudent;
import ua.foxminded.javaspring.schooldb.option.AddStudentToCourse;
import ua.foxminded.javaspring.schooldb.option.AllStudentFromCourse;
import ua.foxminded.javaspring.schooldb.option.DeleteStudent;
import ua.foxminded.javaspring.schooldb.option.DeleteStudentFromCourse;
import ua.foxminded.javaspring.schooldb.option.StudentCountChecker;

@Component
@Profile("!test")
public class Starter {

	private final Scanner scanner;
	private final StudentCountChecker countGroupFinder;
	private final AllStudentFromCourse studentFromCourse;
	private final AddStudent addStudent;
	private final DeleteStudent deleteStudent;
	private final AddStudentToCourse studentToCourse;
	private final DeleteStudentFromCourse deleteStudentFromCourse;
	private final StartMenu startMenu;

	public Starter(Scanner scanner, StudentCountChecker countGroupFinder, AllStudentFromCourse studentFromCourse,
			AddStudent addStudent, DeleteStudent deleteStudent, AddStudentToCourse studentToCourse,
			DeleteStudentFromCourse deleteStudentFromCourse, StartMenu startMenu) {
		this.scanner = scanner;
		this.countGroupFinder = countGroupFinder;
		this.studentFromCourse = studentFromCourse;
		this.addStudent = addStudent;
		this.deleteStudent = deleteStudent;
		this.studentToCourse = studentToCourse;
		this.deleteStudentFromCourse = deleteStudentFromCourse;
		this.startMenu = startMenu;
	}

	@PostConstruct
	public void appStart() {
		boolean exit = false;
		startMenu.startMenu();

		while (!exit) {
			try {
				switch (scanner.nextLine()) {
				case "1": {
					countGroupFinder.checkByCount();
					break;
				}
				case "2": {
					studentFromCourse.findAllStudentsAtCourse();
					break;
				}
				case "3": {
					addStudent.addStudent();
					break;
				}
				case "4": {
					deleteStudent.deleteStudent();
					break;
				}
				case "5": {
					studentToCourse.addStudentToCourse();
					break;
				}
				case "6": {
					deleteStudentFromCourse.deleteFromCourse();
					break;
				}
				case "x": {
					exit = true;
					break;
				}
				default:
					startMenu.startMenu();
					System.out.println("Enter number of option you want");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
