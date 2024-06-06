package com.globtechpower.globtpfapidata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globtechpower.globtpfapidata.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	
	Course findByCourseName(String coursename);

}
