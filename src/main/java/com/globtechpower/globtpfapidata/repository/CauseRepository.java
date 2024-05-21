package com.globtechpower.globtpfapidata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globtechpower.globtpfapidata.model.Cause;

@Repository
public interface CauseRepository extends JpaRepository<Cause, Long> {

}
