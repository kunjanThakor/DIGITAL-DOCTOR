package com.globtechpower.globtpfapidata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.globtechpower.globtpfapidata.config.SecurityConfig;

@SpringBootApplication
//@Import(SecurityConfig.class)
public class GlobtpfapidataApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobtpfapidataApplication.class, args);
	}

}
