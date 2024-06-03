package com.globtechpower.globtpfapidata.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	@Column(length = 50000)
	private String description;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "project_images", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "image_id") })
	private ProjectImage projectImage;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "project_detail_id", referencedColumnName = "id")
	private ProjectDetail projectDetail;

	public Project() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProjectImage getProjectImage() {
		return projectImage;
	}

	public void setProjectImage(ProjectImage projectImage) {
		this.projectImage = projectImage;
	}

	public ProjectDetail getProjectDetails() {
		return projectDetail;
	}

	public void setProjectDetails(ProjectDetail projectDetail) {
		this.projectDetail = projectDetail;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", title=" + title + ", description=" + description + ", projectImage="
				+ projectImage + ", projectDetails=" + projectDetail + "]";
	}
}
