package ua.foxminded.javaspring.schooldb.dao;

import java.util.List;

import ua.foxminded.javaspring.schooldb.model.CountStudentsAtGroup;
import ua.foxminded.javaspring.schooldb.model.Group;

public interface GroupDAO {

	List<Group> listOfGroups();

	List<CountStudentsAtGroup> counterStudentsAtGroups(int count);
}
