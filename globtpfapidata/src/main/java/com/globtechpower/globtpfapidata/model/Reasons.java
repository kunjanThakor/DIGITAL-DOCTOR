package com.globtechpower.globtpfapidata.model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Reasons {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "reasons_images", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "image_id") })
    private Set<ReasonImage> reasonImages;

    public Reasons() {
        // Constructor
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

    public Set<ReasonImage> getReasonImages() {
        return reasonImages;
    }

    public void setReasonImages(Set<ReasonImage> reasonImages) {
        this.reasonImages = reasonImages;
    }

}
