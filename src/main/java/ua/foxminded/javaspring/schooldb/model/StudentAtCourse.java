package ua.foxminded.javaspring.schooldb.model;

public class StudentAtCourse {

	private Long enrollmentID;
	private String firstName;
	private String lastName;
	private String courseName;
	private String courseDescription;

	public StudentAtCourse(Long enrollmentID) {
		this.enrollmentID = enrollmentID;
	}

	public StudentAtCourse(String firstName, String lastName, String courseName, String courseDescription) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
	}

	public StudentAtCourse(Long enrollmentID, String firstName, String lastName, String courseName,
			String courseDescription) {
		this.enrollmentID = enrollmentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public Long getEnrollmentID() {
		return enrollmentID;
	}
}