package ua.foxminded.javaspring.schooldb.output;

import org.springframework.stereotype.Component;

import ua.foxminded.javaspring.schooldb.dao.GroupDAO;
import ua.foxminded.javaspring.schooldb.model.Group;

@Component
public class ShowGroupsList {

	private final GroupDAO groupDAO;

	public ShowGroupsList(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}

	public void groupsList() {

		for (Group group : groupDAO.listOfGroups()) {
			long groupId = group.getGroupID();
			String groupName = group.getGroupName();
			System.out.println(String.format("%d. Group name- %s", groupId, groupName));
		}
	}
}
