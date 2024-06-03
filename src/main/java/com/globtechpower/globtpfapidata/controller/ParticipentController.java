package com.globtechpower.globtpfapidata.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.globtechpower.globtpfapidata.config.UserServiceImp;
import com.globtechpower.globtpfapidata.model.Participent;
import com.globtechpower.globtpfapidata.repository.ParticipentRepository;
import com.globtechpower.globtpfapidata.service.ParticipentService;

@RestController
@CrossOrigin(origins = "*")
//@CrossOrigin
public class ParticipentController {

	@Autowired
	private PasswordEncoder passwordEncoder; // Inject PasswordEncoder bean
	@Autowired
	ParticipentService participentService;
	@Autowired
	UserServiceImp userServiceImp;

	@Autowired
	ParticipentRepository pr;

	@PostMapping("/addparticpent")
	@ResponseBody
	public Participent addData(@RequestBody Participent particpent) {
		particpent.setPassword(passwordEncoder.encode(particpent.getPassword()));
		List<String> nr = new ArrayList<String>();
		nr.addAll(particpent.getRoles());
		particpent.setRoles(nr);
		particpent.setAccountNonLocked(true);
		particpent.setEnabled(false);
		return participentService.addParticipent(particpent);
	}

	@GetMapping("/sec/showpart")
	public List<Participent> showData() {
		return participentService.getParticipents();
	}

	@GetMapping("/sec/auth")
	public void showPart() {

	}

	@GetMapping("/sec/fnb/{email}")
	public Participent showDataTwo(@PathVariable String email) {
		Participent participent = pr.findByEmail(email);
//		participent.setEnabled(true);
//		participent.setAccountNonLocked(true);
//		
		return pr.findByEmail(email);
	}

	@PostMapping("/sec/bylogin")
	public Participent getLogin(@RequestBody Map<String, String> loginData) {
		String email = loginData.get("email");
		String password = loginData.get("password");
		Participent p = participentService.getByEmial(email);
//		System.out.println(p.isEnabled() + " " + p.isAccountNonLocked());
		if (p != null && passwordEncoder.matches(password, p.getPassword())) {
			return p;
		} else {
			return null;
		}

	}
	
	
	
	
	@GetMapping("/sec/displaydisabled")
	List<Participent> disabledParticipents(){
		List<Participent> participents = pr.findByEnabledFalse();
		return participents;
	}
	
	@GetMapping("/sec/usercount")
	int getUserCount() {
		List<Participent> participents = pr.findByEnabledFalse();
		return participents.size();
	}
	
	@GetMapping("/sec/enable/{id}/{enabled}")
	 public ResponseEntity<?> toggleEnable(@PathVariable Long id, @PathVariable boolean enabled) {
		Participent participant = pr.findById(id).get();
        participant.setEnabled(enabled);
        pr.save(participant);
		return ResponseEntity.ok().build();
	}
	
	
	
	@PostMapping("/sec/forgotpassword")
	public void forgotPassword(@RequestBody Map<String, String> data) {
		String email = data.get("email");
		String password = passwordEncoder.encode(data.get("password"));
		participentService.updatePassword(email,password);
	}
	
}
