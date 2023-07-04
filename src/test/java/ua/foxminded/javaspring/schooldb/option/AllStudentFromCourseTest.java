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
import ua.foxminded.javaspring.schooldb.input.InputNumbers;
import ua.foxminded.javaspring.schooldb.model.Course;
import ua.foxminded.javaspring.schooldb.model.StudentAtCourse;
import ua.foxminded.javaspring.schooldb.output.ShowCoursesList;

@RunWith(MockitoJUnitRunner.class)
public class AllStudentFromCourseTest {

	@Mock
	CourseDAO mockCourseDAO;

	@Mock
	ShowCoursesList mockListOfCourses;

	@Mock
	InputNumbers mockInputNumbers;

	@InjectMocks
	AllStudentFromCourse studentFromCourse;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void checkAllStudentFromCourse() {
		List<StudentAtCourse> courseList = new ArrayList<>();
		courseList.add(new StudentAtCourse("test", "test", "test", "test"));
		courseList.add(new StudentAtCourse("test", "test", "test", "test"));
		courseList.add(new StudentAtCourse("test", "test", "test", "test"));
		courseList.add(new StudentAtCourse("test", "test", "test", "test"));
		courseList.add(new StudentAtCourse("test", "test", "test", "test"));

		when(mockInputNumbers.input()).thenReturn(3);
		when(mockCourseDAO.listOfStudentsAtCourse(any(Course.class))).thenReturn(courseList);

		Course inputCourseID = new Course(Long.valueOf(mockInputNumbers.input()));
		List<StudentAtCourse> result = mockCourseDAO.listOfStudentsAtCourse((inputCourseID));

		assertNotNull(result);
		assertEquals(3, inputCourseID.getCourseID());
		assertThat(result).usingRecursiveComparison().isEqualTo(courseList);

		verify(mockInputNumbers).input();
		verify(mockCourseDAO).listOfStudentsAtCourse(any(Course.class));
	}
}
