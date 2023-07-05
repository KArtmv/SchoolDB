package ua.foxminded.javaspring.schooldb.input;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ua.foxminded.javaspring.schooldb.model.Student;
import ua.foxminded.javaspring.schooldb.output.ShowGroupsList;

public class InputStudentDataTest {

	@Test
	void checkInputDataOfStudentTest() {
		ShowGroupsList mockListOfGroups = Mockito.mock(ShowGroupsList.class);

		InputText mockInputData = Mockito.mock(InputText.class);
		Mockito.when(mockInputData.input()).thenReturn("test");

		InputNumbers mockNumbers = Mockito.mock(InputNumbers.class);
		Mockito.when(mockNumbers.input()).thenReturn(1);

		InputStudentData dataOfStudent = new InputStudentData(mockListOfGroups, mockInputData, mockNumbers);

		Student result = dataOfStudent.inputData();

		assertNotNull(result);
		assertEquals("test", result.getFirstName());
		assertEquals("test", result.getLastrName());
		assertEquals(1L, result.getGroupID());
		assertNull(result.getStudentID());

		verify(mockInputData, times(2)).input();
		verify(mockListOfGroups).groupsList();
		verify(mockNumbers).input();
	}
}
