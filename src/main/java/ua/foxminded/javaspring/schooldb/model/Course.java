package ua.foxminded.javaspring.schooldb.model;

public class Course {

	private long courseId;
	private String courseName;
	private String courseDescription;

	public Course(long courseId) {
		this.courseId = courseId;
	}

	public Course(String courseName, String courseDescription) {
		this.courseName = courseName;
		this.courseDescription = courseDescription;
	}

	public Course(long courseId, String courseName, String courseDescription) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
	}

	public long getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}
}
