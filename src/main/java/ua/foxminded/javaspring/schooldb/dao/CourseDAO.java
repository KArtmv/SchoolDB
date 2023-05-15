package ua.foxminded.javaspring.schooldb.dao;

import java.util.List;

import ua.foxminded.javaspring.schooldb.model.Course;
import ua.foxminded.javaspring.schooldb.model.Student;
import ua.foxminded.javaspring.schooldb.model.StudentToCourse;

public interface CourseDAO {

	List<Course> listOfCourse();

	List<StudentToCourse> listOfStudentsAtCourse(Course courseId);

	boolean deleteStudentFromTheirAllCourses(Student studentId);

	boolean addStudentAtCourse(Student studentId, Course courseId);

	boolean deleteStudentFromTheCourse(StudentToCourse enrollmenId);
}
