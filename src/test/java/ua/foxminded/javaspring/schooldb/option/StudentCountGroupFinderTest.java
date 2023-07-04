package ua.foxminded.javaspring.schooldb.option;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
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

import ua.foxminded.javaspring.schooldb.dao.GroupDAO;
import ua.foxminded.javaspring.schooldb.input.InputNumbers;
import ua.foxminded.javaspring.schooldb.model.CountStudentsAtGroup;

@RunWith(MockitoJUnitRunner.class)
public class StudentCountGroupFinderTest {

	@Mock
	GroupDAO mockGroupDAO;

	@Mock
	InputNumbers mockNumbers;

	@InjectMocks
	StudentCountChecker groupFinder;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void checkStudentCountGroupFinder() {
		List<CountStudentsAtGroup> studentsAtGroups = new ArrayList<>();
		studentsAtGroups.add(new CountStudentsAtGroup(1, "test"));
		studentsAtGroups.add(new CountStudentsAtGroup(2, "test"));
		studentsAtGroups.add(new CountStudentsAtGroup(3, "test"));

		when(mockNumbers.input()).thenReturn(21);
		when(mockGroupDAO.counterStudentsAtGroups(anyInt())).thenReturn(studentsAtGroups);

		int inputCount = mockNumbers.input();
		List<CountStudentsAtGroup> result = mockGroupDAO.counterStudentsAtGroups(inputCount);

		assertNotNull(result);
		assertThat(studentsAtGroups).usingRecursiveComparison().isEqualTo(result);

		verify(mockNumbers).input();
		verify(mockGroupDAO).counterStudentsAtGroups(anyInt());
	}
}
