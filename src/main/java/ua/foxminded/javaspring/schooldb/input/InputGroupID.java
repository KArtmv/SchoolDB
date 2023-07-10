package ua.foxminded.javaspring.schooldb.input;

import org.springframework.stereotype.Component;

import ua.foxminded.javaspring.schooldb.dao.GroupDAO;
import ua.foxminded.javaspring.schooldb.model.Group;

@Component
public class InputGroupID {

	private final GroupDAO groupDAO;
	private final InputNumbers inputID;

	public InputGroupID(GroupDAO groupDAO, InputNumbers inputID) {
		this.groupDAO = groupDAO;
		this.inputID = inputID;
	}

	private Group groupID;

	public Group inputID() {

		boolean exist = false;

		while (!exist) {
			groupID = new Group(Long.valueOf(inputID.input()));

			if (!groupDAO.isValidGroupID(groupID)) {
				System.out.println("Invalid course ID");
			} else {
				exist = true;
			}
		}
		return groupID;
	}
}