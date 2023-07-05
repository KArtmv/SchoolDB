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

@RunWith(MockitoJUnitRunner.class)
public class InputTextTest {

	@Mock
	private InputText inputData;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
		void checkInputNumbers() {
			when(inputData.input()).thenReturn("test");
			
			String result = inputData.input();
			
			assertNotNull(result);
			assertEquals("test", result);
			
			verify(inputData).input();
		
	}
}
