package com.globtechpower.globtpfapidata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.globtechpower.globtpfapidata.model.Course;
import com.globtechpower.globtpfapidata.model.Student;
import com.globtechpower.globtpfapidata.repository.StudentRepository;
import com.globtechpower.globtpfapidata.service.StudentServices;

@SpringBootTest
class GlobtpfapidataApplicationTests {

	@Test
	void contextLoads() {
	}
	/*
	 * @Autowired private StudentServices studentServices;
	 * 
	 * @Autowired private StudentRepository studentRepository;
	 * 
	 * @Test public void testGetAllStudents_EmptyList() { List<Student>
	 * expectedStudents = new ArrayList<>(); Student s =
	 * studentRepository.findById(4L).get(); expectedStudents.add(s); List<Student>
	 * actualStudents = studentServices.getAllStudents();
	 * System.out.println(actualStudents.toString() + " " +
	 * expectedStudents.toString()); if (expectedStudents.contains(actualStudents))
	 * { assertTrue(true); } }
	 * 
	 * @Test public void testCreateStudent() { Student newStudent = new
	 * Student("John Doe", "john.doe@example.com", null, null, null); Student
	 * createdStudent = studentServices.createStudent(newStudent);
	 * assertNotNull(createdStudent); assertEquals(newStudent.getStudentName(),
	 * createdStudent.getStudentName()); assertEquals(newStudent.getEmail(),
	 * createdStudent.getEmail()); }
	 */

	@Mock
	private StudentRepository studentRepository; // Mocked StudentRepository
    @InjectMocks
	private StudentServices studentService;

	@Test
	public void testGetAllStudents_EmptyList() {
	    Mockito.when(studentRepository.findAll()).thenReturn(Collections.emptyList());
	    List<Student> actualStudents = studentService.getAllStudents();
	    assertEquals(Collections.emptyList(), actualStudents);
	}

	@Test
	public void testCreateStudent() {
	 Student newStudent = new Student("John Doe", "john.doe@example.com", null, null, null);
	 Mockito.when(studentRepository.save(newStudent)).thenReturn(newStudent);
	 Student createdStudent = studentService.createStudent(newStudent);
	 assertEquals(newStudent, createdStudent);
	}
}
