package com.globtechpower.globtpfapidata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globtechpower.globtpfapidata.model.VideoUpload;

@Repository
public interface VideoRepository extends JpaRepository<VideoUpload, Long> {
	
}
