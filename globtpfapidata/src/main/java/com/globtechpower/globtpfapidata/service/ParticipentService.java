package com.globtechpower.globtpfapidata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globtechpower.globtpfapidata.model.Participent;
import com.globtechpower.globtpfapidata.repository.ParticipentRepository;

@Service
public class ParticipentService {
	@Autowired
	ParticipentRepository participentRepository;

	public Participent addParticipent(Participent participent) {
		return participentRepository.save(participent);
		 
	}
	
	public List<Participent> getParticipents(){
		return participentRepository.findAll();
	}
	
	public Participent getByEmialAndPassowrd(String email,String password) {
		return participentRepository.findByEmailAndPassword(email,password);
	}
	public Participent getByEmial(String email) {
		return participentRepository.findByEmail(email);
	}
}
