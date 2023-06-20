package ua.foxminded.javaspring.schooldb.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import ua.foxminded.javaspring.schooldb.model.Student;
import ua.foxminded.javaspring.schooldb.model.StudentToCourse;

@Repository 
public interface StudentDAO {

	Optional<Student> getStudentById(Student studentId);

	boolean deleteStudent(Student student);

	List<StudentToCourse> listOfCoursesOfStudent(Student studentId);

	boolean createStudent(Student student);

	boolean isValidStudentId(Student studentId);
}
