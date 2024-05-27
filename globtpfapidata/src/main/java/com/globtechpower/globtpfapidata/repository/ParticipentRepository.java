package com.globtechpower.globtpfapidata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globtechpower.globtpfapidata.model.Participent;

@Repository
public interface ParticipentRepository extends JpaRepository<Participent, Long> {
	Participent findByEmailAndPassword(String email, String password);
    Participent findByEmail(String email);
}
