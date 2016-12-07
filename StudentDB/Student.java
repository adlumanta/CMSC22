import java.io.Serializable;

public class Student implements Serializable {
	public static final long serialVersionUID = -6996263656966281480L;
	private String studentNumber;
	private String firstName;
	private char middleInitial;
	private String lastName;
	private String course;
	private int yearLevel;
	private String crushName;
	private Course favoriteCourse;
	
	public Student(String studentNumber, String firstName, char middleInitial, String lastName, String course, int yearLevel, String crushName, Course favoriteSubject) {
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.lastName = lastName;
		this.course = course;
		this.yearLevel = yearLevel;
		this.crushName = crushName;
		this.course = course;
		this.favoriteCourse = favoriteSubject;
	}
	
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public char getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(char middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getYearLevel() {
		return yearLevel;
	}
	public void setYearLevel(int yearLevel) {
		this.yearLevel = yearLevel;
	}

	public Course getFavoriteCourse() {
		return favoriteCourse;
	}

	public void setFavoriteCourse(Course favoriteCourse) {
		this.favoriteCourse = favoriteCourse;
	}

	public String getCrushName() {
		return crushName;
	}

	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}

	@Override
	public String toString() {
		return "Student [studentNumber=" + studentNumber + ", firstName="
				+ firstName + ", middleInitial=" + middleInitial
				+ ", lastName=" + lastName + ", course=" + course
				+ ", yearLevel=" + yearLevel + ", crushName=" + crushName
				+ ", favoriteCourse=" + favoriteCourse + "]";
	}
	
	
}