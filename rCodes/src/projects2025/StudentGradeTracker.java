package projects2025;
import java.util.*;
/*
 * © 2025 Rishi
 * Last updated: 24th August, 2025
 * This program is going to assist in tracking & analyzing student grades.
 * This came as an idea generated from AI.
 * 
 */
public class StudentGradeTracker {

	public double getAverage(Student student) {
		double average = 0;
		for (int i = 0; i < student.getNumberOfCourses(); i++) {
			average += student.getCourse(i).getCourseGrade();
		}
		average /= student.getNumberOfCourses();
		return average;
	}	
	
	
}

class StudentDLL {
	private Student head; //The head (first student)
	
	private Student tail; //The tail (last student)
}
class Student {
	private String name; //This will contain the student's name
	private Course[] courses; //This contains the courses the student is taking
	private int id; //This is to be the student's ID number
	Student() {
		//default constructor
		this.name = "";
		this.id = 0;
		
	}
	Student(String name, Course[] courses, int id) {
		//constructor with name, course(s), id;
		this.name = name;
		this.courses = courses;
		this.id = id;
	}
	
	public String getName() {
		//This method returns the student's name
		return this.name;
	}
	public void setName(String name) {
		//This method sets the student's name
		this.name = name;
	}
	
	public Course getCourse(int i) {
		//This method returns the course at the said index
		return ((i < this.courses.length) && (i >= 0)) ? this.courses[i]: null;
	}
	public Course getCourse(String courseCode) {
		//This is an alternative method to get a course
		for (int i = 0; i < this.courses.length; i++) {
			if (this.courses[i].getCourseCode().equals(courseCode)) {
				return this.courses[i];
			}
		}
		return null;
	}
	
	public void addCourse(Course course) {
		//This method adds a course to the end of the array
		Course[] coursesListUpdated = new Course [this.courses.length + 1];
		for (int i = 0; i < this.courses.length; i++) {
			coursesListUpdated[i] = this.courses[i];
		}
		coursesListUpdated[this.courses.length] = course;
		this.courses = coursesListUpdated;
	}
	
	public void removeCourse(Course course) {
		//This method removes the said course from the array
		Course[] coursesListUpdated = new Course [this.courses.length - 1];
		int index = -1;
		for (int i = 0; i < this.courses.length; i++) {
			if (this.courses[i].equals(course)) {
				index = i;
				break;
			}
			coursesListUpdated[i] = this.courses[i];
		}
		for (int i = index; i < coursesListUpdated.length; i++) {
			coursesListUpdated[i] = this.courses[i + 1];
		}
		
	}
	
	public int getNumberOfCourses() {
		//Get total number of courses student is taking
		return this.courses.length;
	}
	
	public int getStudentID() {
		//This method returns the student's ID number
		return this.id;
	}
	
	public void setStudentID(int id) {
		//This method sets a student's ID number
		this.id = id;
	}
	
	
	
	
}

class Course {
	private String courseCode; //This will be the course name
	private double courseGrade; //This will be the course grade
	
	Course() {
		//default constructor
		this.courseCode = "";
		this.courseGrade = 0.0;
	}
	
	Course(String courseCode, double courseGrade) {
		//constructor with course code & grade
		this.courseCode = courseCode;
		this.courseGrade = courseGrade;
	}
	
	public String getCourseCode() {
		//This method returns the course code
		return this.courseCode;
	}
	
	public void setCourseCode(String courseCode) {
		//This method sets the course code
		this.courseCode = courseCode;
	}
	
	public void changeCourseCode(Course course, String courseCode) {
		//This method changes the course code
		course.courseCode = courseCode;
	}
	
	public double getCourseGrade() {
		//This method returns the course grade
		return this.courseGrade;
	}
	
	public void setCourseGrade(double courseGrade) {
		//This method sets the course grade
		this.courseGrade = courseGrade;
	}
	public void changeCourseGrade(Course course, double courseGrade) {
		//This method changes the course grade
		course.courseGrade = courseGrade;
	}
	
	
}


