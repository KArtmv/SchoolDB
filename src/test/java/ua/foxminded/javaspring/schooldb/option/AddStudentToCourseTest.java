package ua.foxminded.javaspring.schooldb.option;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import ua.foxminded.javaspring.schooldb.dao.CourseDAO;
import ua.foxminded.javaspring.schooldb.input.InputNumbers;
import ua.foxminded.javaspring.schooldb.input.InputStudentID;
import ua.foxminded.javaspring.schooldb.model.Course;
import ua.foxminded.javaspring.schooldb.model.Student;
import ua.foxminded.javaspring.schooldb.output.ShowCoursesList;

@RunWith(MockitoJUnitRunner.class)
public class AddStudentToCourseTest {

	@Mock
	CourseDAO mockCourseDAO;

	@Mock
	ShowCoursesList mockListOfCourses;

	@Mock
	InputStudentID mockInsertStudentID;

	@Mock
	InputNumbers mockInputNumbers;

	@InjectMocks
	private AddStudentToCourse studentToCourse;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void checkAddStudentToCourse() {
		when(mockInsertStudentID.inputID()).thenReturn(new Student(321L));
		when(mockInputNumbers.input()).thenReturn(2);
		when(mockCourseDAO.addStudentToCourse(any(Student.class), any(Course.class))).thenReturn(true);

		Student studentID = mockInsertStudentID.inputID();
		int inputCourseID = mockInputNumbers.input();
		Course courseID = new Course(Long.valueOf(inputCourseID));


		assertNotNull(studentID);
		assertNotNull(courseID);
		assertEquals(321, studentID.getStudentID());
		assertEquals(2, courseID.getCourseID());
		assertThat(mockCourseDAO.addStudentToCourse(studentID, courseID)).isTrue();
		
		verify(mockInsertStudentID).inputID();
		verify(mockInputNumbers).input();
		verify(mockCourseDAO).addStudentToCourse(any(Student.class), any(Course.class));
	}
}
