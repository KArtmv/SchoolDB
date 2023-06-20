package ua.foxminded.javaspring.schooldb.model;

public class Student {

	private long studentId;
	private String firstName;
	private String lastrName;
	private long groupId;
	private String groupName;

	public Student() {
	}

	public Student(long studentId) {
		this.studentId = studentId;
	}

	public Student(long studentId, String firstName, String lastrName, String groupName) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastrName = lastrName;
		this.groupName = groupName;
	}

	public Student(String firstName, String lastrName, long groupId) {
		this.firstName = firstName;
		this.lastrName = lastrName;
		this.groupId = groupId;
	}

	public long getStudentId() {
		return studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastrName() {
		return lastrName;
	}

	public long getGroupId() {
		return groupId;
	}

	public String getGroupName() {
		return groupName;
	}
}
