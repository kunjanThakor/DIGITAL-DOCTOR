package com.globtechpower.globtpfapidata.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.globtechpower.globtpfapidata.model.VideoUpload;
import com.globtechpower.globtpfapidata.service.VideoService;

@RestController
@RequestMapping("/sec")
@CrossOrigin(origins = "*")
public class VideoController {

	@Autowired
	VideoService videoService;

	@PostMapping(value = { "/uploadvideo" }, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public void uploadVideo(@RequestPart("video") MultipartFile videoUpload) throws IOException {
		videoService.uploadVideo(videoUpload);
	}

	@GetMapping("/showvideo")
	public List<VideoUpload> showVideo(){
		return videoService.getAllVideo();
	}
	
	@PostMapping("/deletevideo")
	public void deleteVideo(@RequestBody Map<String, Long> deleteData) {
		videoService.deleteVideo(deleteData.get("id"));
	}
}