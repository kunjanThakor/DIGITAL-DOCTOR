package com.globtechpower.globtpfapidata.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.globtechpower.globtpfapidata.config.UserServiceImp;
import com.globtechpower.globtpfapidata.model.Participent;
import com.globtechpower.globtpfapidata.repository.ParticipentRepository;
import com.globtechpower.globtpfapidata.service.ParticipentService;

@RestController
//@CrossOrigin(origins = "*")
@CrossOrigin
public class ParticipentController {

	 @Autowired
	  private PasswordEncoder passwordEncoder;  // Inject PasswordEncoder bean
	@Autowired
	ParticipentService participentService;
	
	@Autowired
	ParticipentRepository pr;
	
	@PostMapping("/addparticpent")
	@ResponseBody
	public Participent addData(@RequestBody Participent particpent) {
		particpent.setPassword(passwordEncoder.encode(particpent.getPassword()));
		List<String> nr = new ArrayList<String>();
		nr.add("ROLE_PARTICIPENT");
		particpent.setRoles(nr);
		return participentService.addParticipent(particpent);
	}
	
	@PostMapping("/adddt")
	public Participent addDatatwo(@RequestBody Participent particpent) {
		particpent.setPassword(passwordEncoder.encode(particpent.getPassword()));
		List<String> nr = new ArrayList<String>();
		nr.add("ROLE_PARTICIPENT");
		particpent.setRoles(nr);
		return participentService.addParticipent(particpent);
	}
	
	@GetMapping("/sec/showpart")
	public List<Participent> showData() {
		return participentService.getParticipents();
	}
	@GetMapping("/auth")
	public void showPart() {
		new UserServiceImp();
	}
	
	@GetMapping("/sec/fnb/{email}")
	public Participent showDataTwo(@PathVariable String email) {
		return pr.findByEmail(email);
	}
	
	@GetMapping("/bylogin/{email}/{passowrd}")
	public Participent getLogin(@PathVariable String email, @PathVariable String passowrd) {
		Participent p = participentService.getByEmial(email);
		boolean isPasswordMatch = passwordEncoder.matches(passowrd,p.getPassword() );
		if (isPasswordMatch) {	
			return participentService.getByEmialAndPassowrd(email, p.getPassword());
		} else {
			return null;
		}
	}
}
