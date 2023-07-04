package ua.foxminded.javaspring.schooldb.dao;

import java.util.List;
import java.util.Optional;

import ua.foxminded.javaspring.schooldb.model.Student;
import ua.foxminded.javaspring.schooldb.model.StudentAtCourse;

public interface StudentDAO {

	Optional<Student> getStudentByID(Student studentID);

	boolean deleteStudent(Student student);

	List<StudentAtCourse> listOfCoursesOfStudent(Student studentID);

	boolean createStudent(Student student);

	boolean isValidStudentID(Student studentID);
}
