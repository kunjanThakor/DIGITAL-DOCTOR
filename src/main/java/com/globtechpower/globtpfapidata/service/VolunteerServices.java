package com.globtechpower.globtpfapidata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globtechpower.globtpfapidata.model.Volunteer;
import com.globtechpower.globtpfapidata.repository.VolunteerRepository;

@Service
public class VolunteerServices {
	@Autowired
	VolunteerRepository volunteerRepository;

	public List<Volunteer> addData(Volunteer volunteer) {
		volunteerRepository.save(volunteer);
		return volunteerRepository.findAll();
	}
	public List<Volunteer> showData() {
		return volunteerRepository.findAll();
	}
	
	
}
