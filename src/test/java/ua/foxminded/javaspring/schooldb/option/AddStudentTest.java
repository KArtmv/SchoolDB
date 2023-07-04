package ua.foxminded.javaspring.schooldb.option;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import ua.foxminded.javaspring.schooldb.dao.StudentDAO;
import ua.foxminded.javaspring.schooldb.input.InputStudentData;
import ua.foxminded.javaspring.schooldb.model.Student;

@RunWith(MockitoJUnitRunner.class)
public class AddStudentTest {

	@Mock
	StudentDAO mockStudentDAO;

	@Mock
	InputStudentData mockDataOfstudent;

	@InjectMocks
	private AddStudent addStudent;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void checkAddStudent() {
		Student student = new Student("test", "test", 1L);

		when(mockDataOfstudent.inputData()).thenReturn(student);

		when(mockStudentDAO.createStudent(student)).thenReturn(true);

		assertNotNull(student);
		assertThat(mockDataOfstudent.inputData()).usingRecursiveComparison().isEqualTo(student);

		assertThat(mockStudentDAO.createStudent(student)).isTrue();

		verify(mockDataOfstudent).inputData();
		verify(mockStudentDAO).createStudent(student);
	}
}