package com.globtechpower.globtpfapidata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globtechpower.globtpfapidata.model.Cause;
import com.globtechpower.globtpfapidata.repository.CauseRepository;

@Service
public class CauseServices {
	@Autowired
	CauseRepository causeRepository;

	public List<Cause> getAllCauses() {
		return causeRepository.findAll();
	}

	public Cause addCause(Cause cause) {
		return causeRepository.save(cause);
	}
}
