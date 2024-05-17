package com.globtechpower.globtpfapidata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globtechpower.globtpfapidata.model.Reasons;

@Repository
public interface ReasonRepository extends JpaRepository<Reasons, Long> {

	List<Reasons> findByTitle(String title);

}
