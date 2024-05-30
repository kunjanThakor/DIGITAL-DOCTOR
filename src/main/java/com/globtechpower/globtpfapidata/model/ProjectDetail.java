package com.globtechpower.globtpfapidata.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.globtechpower.globtpfapidata.converter.LocalDateConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProjectDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate startingDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate endingDate;

    public ProjectDetail() {

    }

    @Override
    public String toString() {
        return "ProjectDetail [id=" + id + ", startingDate=" + startingDate + ", endingDate=" + endingDate + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }
}
