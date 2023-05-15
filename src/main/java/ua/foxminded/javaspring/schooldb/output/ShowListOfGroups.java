package ua.foxminded.javaspring.schooldb.output;

import ua.foxminded.javaspring.schooldb.dao.GroupDAO;
import ua.foxminded.javaspring.schooldb.model.Groupe;

public class ShowListOfGroups {

	private final GroupDAO groupDAO;

	public ShowListOfGroups(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}

	public void showListOfGroups() {

		for (Groupe group : groupDAO.listOfGroups()) {
			long groupId = group.getGroupId();
			String groupName = group.getGroupName();
			System.out.println(String.format("%d. Group name- %s", groupId, groupName));
		}
	}
}
