package com.globtechpower.globtpfapidata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globtechpower.globtpfapidata.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
