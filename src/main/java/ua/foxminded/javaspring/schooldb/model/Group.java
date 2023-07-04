package ua.foxminded.javaspring.schooldb.model;

public class Group {

	private Long groupID;
	private String groupName;

	public Group(Long groupID) {
		this.groupID = groupID;
	}

	public Group(String groupName) {
		this.groupName = groupName;
	}

	public Group(Long groupId, String groupName) {
		this.groupID = groupId;
		this.groupName = groupName;
	}

	public long getGroupID() {
		return groupID;
	}

	public String getGroupName() {
		return groupName;
	}
}
