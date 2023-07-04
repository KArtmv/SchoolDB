package ua.foxminded.javaspring.schooldb.model;

public class Student {

	private Long studentID;
	private String firstName;
	private String lastrName;
	private Long groupID;
	private String groupName;

	public Student(Long studentID) {
		this.studentID = studentID;
	}

	public Student(Long studentID, String firstName, String lastrName, String groupName) {
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastrName = lastrName;
		this.groupName = groupName;
	}

	public Student(String firstName, String lastrName, Long groupID) {
		this.firstName = firstName;
		this.lastrName = lastrName;
		this.groupID = groupID;
	}

	public Long getStudentID() {
		return studentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastrName() {
		return lastrName;
	}

	public Long getGroupID() {
		return groupID;
	}

	public String getGroupName() {
		return groupName;
	}
}
