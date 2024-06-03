package com.globtechpower.globtpfapidata.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.globtechpower.globtpfapidata.model.VideoUpload;
import com.globtechpower.globtpfapidata.repository.VideoRepository;

@Service
public class VideoService {

	@Autowired
	VideoRepository videpRepository;

	public void uploadVideo(MultipartFile videoUpload) throws IOException {
		videpRepository.save(upload(videoUpload));
	}
	
	private VideoUpload upload(MultipartFile image) throws IOException {
		VideoUpload video = new VideoUpload(image.getOriginalFilename(),image.getContentType(),image.getBytes());
		return video;
	}

	public List<VideoUpload> getAllVideo() {
		return videpRepository.findAll();
	}

	public void deleteVideo(Long id) {
			videpRepository.deleteById(id);
		
	}
	
	
}
