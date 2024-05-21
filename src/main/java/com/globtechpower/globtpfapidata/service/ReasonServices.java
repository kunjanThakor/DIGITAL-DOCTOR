package com.globtechpower.globtpfapidata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globtechpower.globtpfapidata.model.Reasons;
import com.globtechpower.globtpfapidata.repository.ReasonRepository;

@Service
public class ReasonServices {
	@Autowired
	ReasonRepository reasonRepository;
	
	public List<Reasons> addReasons(Reasons reasons){
		reasonRepository.save(reasons);
		return reasonRepository.findAll();
	}
	
	public List<Reasons> showReasons(){
		return reasonRepository.findAll();
	}
	
	public List<Reasons> getReasonByTitile(String title){
		return reasonRepository.findByTitle(title);
	}
}
