package ua.foxminded.javaspring.schooldb.input;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import ua.foxminded.javaspring.schooldb.model.Student;

@RunWith(MockitoJUnitRunner.class)
public class InputStudentIdTest {

	@Mock
	private InputStudentID mockStudentID;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void checkInputStudentId() {
		when(mockStudentID.inputID()).thenReturn(new Student(162L));
		
		Student studentID = mockStudentID.inputID();
		
		assertNotNull(studentID);
		assertEquals(162, studentID.getStudentID());
		
		verify(mockStudentID).inputID();
	}

}
