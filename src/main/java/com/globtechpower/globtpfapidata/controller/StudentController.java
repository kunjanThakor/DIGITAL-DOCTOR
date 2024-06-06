package com.globtechpower.globtpfapidata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globtechpower.globtpfapidata.model.Student;
import com.globtechpower.globtpfapidata.service.StudentServices;

@RestController
@RequestMapping("/sec")
@CrossOrigin(origins = "*")
public class StudentController {

	@Autowired
	private StudentServices studentService;

	@GetMapping("/getallstudents")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@GetMapping("studentbyid/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}

	@PostMapping("/createstudent")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	@PutMapping("/updatestudent/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		student.setId(id);
		return studentService.updateStudent(student);
	}

	@DeleteMapping("deletebyid/{id}")
	public void deleteStudentById(@PathVariable Long id) {
		studentService.deleteStudentById(id);
	}

}
