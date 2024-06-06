package com.globtechpower.globtpfapidata.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String studentName;
	private String mobileNumber;
	private String email;
	private String password;
	
	@ManyToOne
    @JoinTable(
        name = "student_courses",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Course courses;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Student(String studentName, String mobileNumber, String email, String password,Course course) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.courses =course;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
//	public List<Course> getCourse() {
//		return courses;
//	}
//	public void setCourse(List<Course> course) {
//		courses = course;
//	}
	
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public Course getCourses() {
		return courses;
	}
	public void setCourses(Course courses) {
		this.courses = courses;
	}
	
}
