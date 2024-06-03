package com.globtechpower.globtpfapidata.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.globtechpower.globtpfapidata.model.Project;
import com.globtechpower.globtpfapidata.model.ProjectDetail;
import com.globtechpower.globtpfapidata.service.ProjectServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;

@RestController
@RequestMapping("/sec")
public class ProjectController {

	@Autowired
	ProjectServices projectServices;

	@PostMapping(value = { "/addprojects" }, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public Project getMethodName(@RequestPart("project") Project project,@RequestPart("projectdetail")ProjectDetail projectDetails, @RequestPart("image") MultipartFile image) throws IOException {
		return projectServices.addProject(project,projectDetails, image);
	}
	
	@GetMapping("/getProjectById/{id}")
	public Project getProjectById(@PathVariable Long id) {
		return projectServices.getProjectById(id);
	}
	
	@GetMapping("/getAllProjects")
	public List<Project> getAllProjects(){
		return projectServices.getAllProjects();
	}
	
	@DeleteMapping("/deleteall")
	public String deleteAll() {
		projectServices.deleteAllProjects();
		return "Delete All";
	}
	
	@PostMapping("/deletebyid")
	public void deleteById(@RequestBody Long id) {
		projectServices.deleteById(id);
	}
	
	@PostMapping("/update")
	public void updateProject(@RequestBody Project project) {
		projectServices.updateProject(project);
	}

}
