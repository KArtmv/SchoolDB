package ua.foxminded.javaspring.schooldb.dao;

import java.util.List;
import java.util.Map;

import ua.foxminded.javaspring.schooldb.model.Group;

public interface GroupDAO {

	List<Group> listOfGroups();

	List<Map<String, Object>> counterStudentsAtGroups(int count);
}
