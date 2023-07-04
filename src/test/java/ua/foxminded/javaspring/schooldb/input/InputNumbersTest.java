package ua.foxminded.javaspring.schooldb.input;

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
public class InputNumbersTest {

	@Mock
	private InputNumbers mockInputNumbers;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void checkInputNumbers() {
		when(mockInputNumbers.input()).thenReturn(1);
		
		int result = mockInputNumbers.input();
		
		assertEquals(1, result);
		
		verify(mockInputNumbers).input();
	}
}
