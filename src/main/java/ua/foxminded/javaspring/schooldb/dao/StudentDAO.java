package ua.foxminded.javaspring.schooldb.dao;

import java.util.List;

import ua.foxminded.javaspring.schooldb.model.Student;
import ua.foxminded.javaspring.schooldb.model.StudentToCourse;

public interface StudentDAO {

	Student getStudentById(Student studentId);

	boolean deleteStudent(Student student);

	List<StudentToCourse> listOfCoursesOfStudent(Student studentId);

	boolean createStudent(Student student);

	boolean isValidStudentId(Student studentId);
}
