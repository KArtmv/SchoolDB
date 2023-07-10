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
	private InputText inputText;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
		void input_returnString_whenInputText() {
			when(inputText.input()).thenReturn("test");
			
			String result = inputText.input();
			
			assertNotNull(result);
			assertEquals("test", result);
			
			verify(inputText).input();
		
	}
}
