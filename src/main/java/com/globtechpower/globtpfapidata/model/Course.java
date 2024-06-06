package com.globtechpower.globtpfapidata.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String courseName;
	private Long numberOfTopics;
	private String description;
	@OneToMany
	private List<Student> students = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Long getNumberOfTopics() {
		return numberOfTopics;
	}

	public void setNumberOfTopics(Long numberOfTopics) {
		this.numberOfTopics = numberOfTopics;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", numberOfTopics=" + numberOfTopics + "]";
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
