package ua.foxminded.javaspring.schooldb.input;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ua.foxminded.javaspring.schooldb.model.Group;
import ua.foxminded.javaspring.schooldb.model.Student;
import ua.foxminded.javaspring.schooldb.output.ShowGroupsList;

public class InputStudentDataTest {

	@Test
	void dataOfStudent_returnNotNull_whenDataIsAre() {
		Student result = inputDataOfStudent();

		assertNotNull(result);
	}

	@Test
	void dataOfStudent_shouldReturnCorrectData_whenDataIsValid() {
		Student result = inputDataOfStudent();

		assertEquals("test", result.getFirstName());
		assertEquals("test", result.getLastName());
		assertEquals(1L, result.getGroupID());
		assertNull(result.getStudentID());
	}

	private Student inputDataOfStudent() {
		ShowGroupsList mockListOfGroups = Mockito.mock(ShowGroupsList.class);

		InputText mockInputData = Mockito.mock(InputText.class);
		Mockito.when(mockInputData.input()).thenReturn("test");

		InputGroupID mockGroupID = Mockito.mock(InputGroupID.class);
		Mockito.when(mockGroupID.inputID()).thenReturn(new Group(1L));

		InputStudentData inputStudentData = new InputStudentData(mockListOfGroups, mockInputData, mockGroupID);

		return inputStudentData.inputData();
	}
}
