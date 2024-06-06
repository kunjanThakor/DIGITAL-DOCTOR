package com.globtechpower.globtpfapidata.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globtechpower.globtpfapidata.model.Course;
import com.globtechpower.globtpfapidata.model.Student;
import com.globtechpower.globtpfapidata.repository.CourseRepository;
import com.globtechpower.globtpfapidata.repository.StudentRepository;

@Service
public class StudentServices {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student getStudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	/*
	 * @Transactional public Student createStudent(Student student) { Set<Course>
	 * uniqueCourses = new HashSet<>();
	 * 
	 * for (Course course : student.getCourse()) { // Check if the course already
	 * exists in the repository Course existingCourse =
	 * courseRepository.findById(course.getId()).orElse(course);
	 * uniqueCourses.add(existingCourse); }
	 * 
	 * // Clear the original course list and add only unique courses
	 * student.getCourse().clear(); student.getCourse().addAll(uniqueCourses);
	 * return studentRepository.save(student); }
	 */

	@Transactional
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student updateStudent(Student student) {
		Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
		if (existingStudent != null) {
			existingStudent.setStudentName(student.getStudentName());
			existingStudent.setEmail(student.getEmail());
			existingStudent.setCourses(student.getCourses());
			studentRepository.save(existingStudent);
		}
		return existingStudent;
	}

	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
	}
}
