package ua.foxminded.javaspring.schooldb;

import java.util.Scanner;

import ua.foxminded.javaspring.schooldb.option.AddStudent;
import ua.foxminded.javaspring.schooldb.option.AddStudentToCourse;
import ua.foxminded.javaspring.schooldb.option.AllStudentFromCourse;
import ua.foxminded.javaspring.schooldb.option.DeleteStudent;
import ua.foxminded.javaspring.schooldb.option.DeleteStudentFromCourse;
import ua.foxminded.javaspring.schooldb.option.StudentCountGroupFinder;

public class SwitchOfMenu {

	private final Scanner scanner;
	private final StudentCountGroupFinder countGroupFinder;
	private final AllStudentFromCourse studentFromCourse;
	private final AddStudent addStudent;
	private final DeleteStudent deleteStudent;
	private final AddStudentToCourse studentToCourse;
	private final DeleteStudentFromCourse deleteStudentFromCourse;

	public SwitchOfMenu(Scanner scanner, StudentCountGroupFinder countGroupFinder,
			AllStudentFromCourse studentFromCourse, AddStudent addStudent, DeleteStudent deleteStudent,
			AddStudentToCourse studentToCourse, DeleteStudentFromCourse deleteStudentFromCourse) {
		this.scanner = scanner;
		this.countGroupFinder = countGroupFinder;
		this.studentFromCourse = studentFromCourse;
		this.addStudent = addStudent;
		this.deleteStudent = deleteStudent;
		this.studentToCourse = studentToCourse;
		this.deleteStudentFromCourse = deleteStudentFromCourse;
	}

	public boolean switchOfMenu(boolean exit, StartMenu startMenu) {

		try {
			String input = scanner.nextLine();
			switch (input) {
			case "1": {
				countGroupFinder.groupFinder();
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
		return exit;
	}
}
