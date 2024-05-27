package com.globtechpower.globtpfapidata.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebMvc
public class SecurityConfig {

	@Autowired
	UserServiceImp userServiceImp;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	DaoAuthenticationProvider authenticationprovider() {
		DaoAuthenticationProvider daoAuthentication = new DaoAuthenticationProvider();
		daoAuthentication.setUserDetailsService(userServiceImp);
		daoAuthentication.setPasswordEncoder(passwordEncoder());
		return daoAuthentication;
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				System.out.println("Cors working....");
				registry.addMapping("/**").allowedOrigins("*")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS").allowedHeaders("*")
						.exposedHeaders("*").allowCredentials(false);
			}
		};
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable());
		http.cors(corse -> corse.disable());
		http.authorizeHttpRequests(authorize -> {
			authorize.requestMatchers("/api.html").hasRole("ADMIN");
			authorize.requestMatchers("/swagger-ui/**").hasRole("ADMIN");
			authorize.requestMatchers("/sec/**").permitAll();
			authorize.requestMatchers("/bylogin").permitAll();
			authorize.requestMatchers("/**").permitAll();
			authorize.anyRequest().permitAll();
		});
		http.formLogin(Customizer.withDefaults());
		return http.build();
	}
}
