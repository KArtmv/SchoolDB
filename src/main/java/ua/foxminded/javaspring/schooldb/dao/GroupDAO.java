package ua.foxminded.javaspring.schooldb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ua.foxminded.javaspring.schooldb.model.CountStudentsAtGroup;
import ua.foxminded.javaspring.schooldb.model.Group;

@Repository
public interface GroupDAO {

	List<Group> listOfGroups();

	List<CountStudentsAtGroup> counterStudentsAtGroups(int count);
}
