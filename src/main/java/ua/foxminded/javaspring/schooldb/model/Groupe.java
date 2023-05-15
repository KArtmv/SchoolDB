package ua.foxminded.javaspring.schooldb.model;

public class Groupe {

	private long groupId;
	private String groupName;

	public Groupe(long groupId) {
		this.groupId = groupId;
	}

	public Groupe(String groupName) {
		this.groupName = groupName;
	}

	public Groupe(long groupId, String groupName) {
		this.groupId = groupId;
		this.groupName = groupName;
	}

	public long getGroupId() {
		return groupId;
	}

	public String getGroupName() {
		return groupName;
	}

}
