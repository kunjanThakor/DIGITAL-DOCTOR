package com.globtechpower.globtpfapidata.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.globtechpower.globtpfapidata.model.Project;
import com.globtechpower.globtpfapidata.model.ProjectDetail;
import com.globtechpower.globtpfapidata.model.ProjectImage;
import com.globtechpower.globtpfapidata.repository.ProjectRepository;

@Service
public class ProjectServices {
	@Autowired
	ProjectRepository projectRepository;


	public Project addProject(Project project ,ProjectDetail projectDetails ,MultipartFile image) throws IOException {
		
		ProjectImage img = uploadImage(image);
		project.setProjectImage(img);
		project.setProjectDetails(projectDetails);
		projectRepository.save(project);
		
		return projectRepository.findById(project.getId()).get();
	}

	public ProjectImage uploadImage(MultipartFile multipartFile) throws IOException {
        // Create VolunteerImage object from MultipartFile
		ProjectImage projectImage = new ProjectImage(multipartFile.getOriginalFilename(),
                                                         multipartFile.getContentType(),
                                                         multipartFile.getBytes());
        return projectImage;
    }

	public Project getProjectById(Long id) {
		return projectRepository.findById(id).get();
	}

	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	public void deleteAllProjects() {
		projectRepository.deleteAll();
		
	}

	public void deleteById(Long id) {
		projectRepository.deleteById(id);
		
	}

	public void updateProject(Project project) {
		Project prj = projectRepository.findById(project.getId()).get();
//		prj.setId(project.getId());
		prj.setDescription(project.getDescription());
		prj.setTitle(project.getTitle());
		projectRepository.save(prj);
		
	}
}
