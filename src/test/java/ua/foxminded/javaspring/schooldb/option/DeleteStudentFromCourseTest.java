package ua.foxminded.javaspring.schooldb.option;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import ua.foxminded.javaspring.schooldb.dao.CourseDAO;
import ua.foxminded.javaspring.schooldb.dao.StudentDAO;
import ua.foxminded.javaspring.schooldb.input.InputNumbers;
import ua.foxminded.javaspring.schooldb.input.InputStudentID;
import ua.foxminded.javaspring.schooldb.model.Student;
import ua.foxminded.javaspring.schooldb.model.StudentAtCourse;
import ua.foxminded.javaspring.schooldb.output.ShowStudentCourses;

@RunWith(MockitoJUnitRunner.class)
public class DeleteStudentFromCourseTest {

	@Mock
	CourseDAO mockCourseDAO;

	@Mock
	StudentDAO mockStudentDAO;

	@Mock
	InputStudentID mockInputStudentID;

	@Mock
	InputNumbers mockNumbers;

	@Mock
	ShowStudentCourses mockCoursesOfStudent;

	@InjectMocks
	DeleteStudentFromCourse deleteStudentFromCourse;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void checkDeleteStudentFromCourse() {
		List<StudentAtCourse> courseList = new ArrayList<>();
		courseList.add(new StudentAtCourse(1L, "test", "test", "test", "test"));
		courseList.add(new StudentAtCourse(2L, "test", "test", "test", "test"));
		courseList.add(new StudentAtCourse(3L, "test", "test", "test", "test"));

		when(mockInputStudentID.inputID()).thenReturn(new Student(1L));
		when(mockStudentDAO.listOfCoursesOfStudent(any(Student.class))).thenReturn(courseList);
		when(mockNumbers.input()).thenReturn(3);
		when(mockCourseDAO.deleteStudentFromTheCourse(any(StudentAtCourse.class))).thenReturn(true);

		Student inputStudentID = mockInputStudentID.inputID();
		List<StudentAtCourse> studentCourseList = mockStudentDAO.listOfCoursesOfStudent(inputStudentID);
		StudentAtCourse inputCourseID = new StudentAtCourse(Long.valueOf(mockNumbers.input()));
		boolean isDeleted = mockCourseDAO.deleteStudentFromTheCourse(inputCourseID);

		assertNotNull(inputStudentID);
		assertNotNull(studentCourseList);
		assertNotNull(inputCourseID);
		assertEquals(1, inputStudentID.getStudentID());
		assertThat(studentCourseList).usingRecursiveComparison().isEqualTo(courseList);
		assertEquals(3, inputCourseID.getEnrollmentID());
		assertThat(isDeleted).isTrue();

		verify(mockInputStudentID).inputID();
		verify(mockStudentDAO).listOfCoursesOfStudent(any(Student.class));
		verify(mockNumbers).input();
		verify(mockCourseDAO).deleteStudentFromTheCourse(any(StudentAtCourse.class));
	}
}
