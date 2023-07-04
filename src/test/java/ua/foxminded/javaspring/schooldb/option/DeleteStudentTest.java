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
import ua.foxminded.javaspring.schooldb.dao.StudentDAO;
import ua.foxminded.javaspring.schooldb.input.InputStudentID;
import ua.foxminded.javaspring.schooldb.model.Student;

@RunWith(MockitoJUnitRunner.class)
public class DeleteStudentTest {

	@Mock
	StudentDAO mockStudentDAO;

	@Mock
	InputStudentID mockInputStudentId;

	@Mock
	CourseDAO mockCourseDAO;

	@InjectMocks
	DeleteStudent deleteStudent;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void checkDeleteStudent() {
		when(mockInputStudentId.inputID()).thenReturn(new Student(1L));
		when(mockCourseDAO.deleteStudentFromTheirAllCourses(any(Student.class))).thenReturn(true);
		when(mockStudentDAO.deleteStudent(any(Student.class))).thenReturn(true);
		
		Student studentID = mockInputStudentId.inputID();

		assertNotNull(studentID);
		assertEquals(1L, studentID.getStudentID());
		assertThat(mockCourseDAO.deleteStudentFromTheirAllCourses(studentID)).isTrue();
		assertThat(mockStudentDAO.deleteStudent(studentID)).isTrue();
		
		verify(mockInputStudentId).inputID();
		verify(mockCourseDAO).deleteStudentFromTheirAllCourses(any(Student.class));
		verify(mockStudentDAO).deleteStudent(any(Student.class));
	}
}
