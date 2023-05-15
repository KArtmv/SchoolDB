package ua.foxminded.javaspring.schooldb.model;

public class Student {

	private long studentId;
	private String firstName;
	private String lastrName;
	private long groupId;

	public Student() {
	}

	public Student(long studentId) {
		this.studentId = studentId;
	}

	public Student(long studentId, String firstName, String lastrName, long groupId) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastrName = lastrName;
		this.groupId = groupId;
	}

	public Student(String firstName, String lastrName, long groupId) {
		this.firstName = firstName;
		this.lastrName = lastrName;
		this.groupId = groupId;
	}

	public long getStudentId() {
		return studentId;
	}

	public long getGroupId() {
		return groupId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastrName() {
		return lastrName;
	}
}
