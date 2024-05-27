package com.globtechpower.globtpfapidata.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.globtechpower.globtpfapidata.model.Participent;
import com.globtechpower.globtpfapidata.repository.ParticipentRepository;

@Service
public class UserServiceImp implements UserDetailsService {
    @Autowired
    private ParticipentRepository participentRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Participent participent = participentRepository.findByEmail(username);
        
        if (participent == null) {
            throw new UsernameNotFoundException("Username not found");
        } else {
        	System.out.println(participent.toString());
            return participent;
        }
    }
}
