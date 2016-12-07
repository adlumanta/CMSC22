import java.io.Serializable;

public class Course implements Serializable {
	private String courseCode;
	private String courseDesc;
	
	public Course(String courseCode, String courseDesc) {
		this.courseCode = courseCode;
		this.courseDesc = courseDesc;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	@Override
	public String toString() {
		return "Course [courseCode=" + courseCode + ", courseDesc="
				+ courseDesc + "]";
	}
	
	
}
