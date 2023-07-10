package ua.foxminded.javaspring.schooldb.model;

public class CountStudentsAtGroup {

	private int count;
	private String groupName;

	public CountStudentsAtGroup(int count, String groupName) {
		this.count = count;
		this.groupName = groupName;
	}

	public int getCount() {
		return count;
	}

	public String getGroupName() {
		return groupName;
	}
}
