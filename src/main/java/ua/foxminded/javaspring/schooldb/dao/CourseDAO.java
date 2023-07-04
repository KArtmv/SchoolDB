package ua.foxminded.javaspring.schooldb.dao;

import java.util.List;

import ua.foxminded.javaspring.schooldb.model.Course;
import ua.foxminded.javaspring.schooldb.model.Student;
import ua.foxminded.javaspring.schooldb.model.StudentAtCourse;

public interface CourseDAO {

	List<Course> listOfCourse();

	List<StudentAtCourse> listOfStudentsAtCourse(Course courseID);

	boolean deleteStudentFromTheirAllCourses(Student studentID);

	boolean addStudentToCourse(Student studentID, Course courseID);

	boolean deleteStudentFromTheCourse(StudentAtCourse enrollmenID);
}
