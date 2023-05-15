package ua.foxminded.javaspring.schooldb.model;

public class StudentToCourse {

	private long enrollmentId;
	private String firstName;
	private String lastName;
	private String courseName;
	private String courseDescription;

	public StudentToCourse(long enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public StudentToCourse(String firstName, String lastName, String courseName, String courseDescription) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
	}

	public StudentToCourse(long enrollmentId, String firstName, String lastName, String courseName,
			String courseDescription) {
		this.enrollmentId = enrollmentId;
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

	public long getEnrollmentId() {
		return enrollmentId;
	}
}