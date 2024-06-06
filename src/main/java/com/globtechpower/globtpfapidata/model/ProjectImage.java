package com.globtechpower.globtpfapidata.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProjectImage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	public ProjectImage() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String name;
	private String type;
	@Column(length = 50000000)
	private byte[] picByte;
	public ProjectImage(Long id, String name, String type, byte[] picByte) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.picByte = picByte;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public byte[] getPicByte() {
		return picByte;
	}
	public ProjectImage(String name, String type, byte[] picByte) {
		super();
		this.name = name;
		this.type = type;
		this.picByte = picByte;
	}
	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}
}
