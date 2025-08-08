package projects2025;
import java.util.*;
/*
 * © 2025 Rishi
 * Last updated: 8th August, 2025
 * This program is going to assist in tracking & analyzing student grades.
 * This came as an idea generated from AI.
 * 
 */
public class StudentGradeTracker {
	
	
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
		//This method adds a course to the end of the array;
		Course[] coursesListUpdated = new Course [this.courses.length + 1];
		for (int i = 0; i < this.courses.length; i++) {
			coursesListUpdated[i] = this.courses[i];
		}
		coursesListUpdated[this.courses.length] = course;
		this.courses = coursesListUpdated;
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
	
	public double getCourseGrade() {
		//This method returns the course grade
		return this.courseGrade;
	}
	
	public void getCourseGrade(double courseGrade) {
		//This method sets the course grade
		this.courseGrade = courseGrade;
	}
}


