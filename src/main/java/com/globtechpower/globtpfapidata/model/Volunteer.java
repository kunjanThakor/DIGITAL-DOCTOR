package com.globtechpower.globtpfapidata.model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Volunteer {
	// Properties
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String expertise;
	private String cause;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "volunteer_images", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name="image_id")
	})
	private Set<VolunteerImage> volunteerImages;

	public Set<VolunteerImage> getVolunteerImages() {
		return volunteerImages;
	}

	public void setVolunteerImages(Set<VolunteerImage> volunteerImages) {
		this.volunteerImages = volunteerImages;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	private boolean available;

	public Volunteer() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	// Constructors, getters, setters, and methods remain the same as before
}