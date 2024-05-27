package com.globtechpower.globtpfapidata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globtechpower.globtpfapidata.model.Cause;
import com.globtechpower.globtpfapidata.service.CauseServices;

@RestController
public class CauseController {

	@Autowired
	CauseServices causeService;

	@GetMapping
	public List<Cause> getAllCauses() {
		return causeService.getAllCauses();
	}

	@PostMapping
	public ResponseEntity<Cause> addCause(@RequestBody Cause cause) {
		Cause newCause = causeService.addCause(cause);
		return new ResponseEntity<>(newCause, HttpStatus.CREATED);
	}
}
