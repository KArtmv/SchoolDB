package ua.foxminded.javaspring.schooldb.dao;

import java.util.List;
import java.util.Map;

import ua.foxminded.javaspring.schooldb.model.Groupe;

public interface GroupDAO {

	List<Groupe> listOfGroups();

	List<Map<String, Object>> counterStudentsAtGroups(int count);
}
