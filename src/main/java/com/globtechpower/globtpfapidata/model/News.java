package com.globtechpower.globtpfapidata.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.globtechpower.globtpfapidata.converter.LocalDateConverter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;

@Entity
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String Description;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "news_images", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "image_id") })
	private NewsImage newsImage;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate newsDate;
	
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
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public NewsImage getNewsImage() {
		return newsImage;
	}
	public void setNewsImage(NewsImage newsImage) {
		this.newsImage = newsImage;
	}
	public LocalDate getNewsDate() {
		return newsDate;
	}
	public void setNewsDate(LocalDate newsDate) {
		this.newsDate = newsDate;
	}
}
