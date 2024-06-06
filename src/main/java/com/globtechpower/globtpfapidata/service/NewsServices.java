package com.globtechpower.globtpfapidata.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.globtechpower.globtpfapidata.model.News;
import com.globtechpower.globtpfapidata.model.NewsImage;
import com.globtechpower.globtpfapidata.repository.NewsRepository;

@Service
public class NewsServices {

	@Autowired
	NewsRepository newsRepository;

	public News uploadNews(News news, MultipartFile image) throws IOException {
		news.setNewsImage(uploadImage(image));
		news.setNewsDate(LocalDate.now());
		newsRepository.save(news);
		return null;
	}
	
	public NewsImage uploadImage(MultipartFile image) throws IOException {
		NewsImage newsImage = new NewsImage(image.getOriginalFilename(), image.getContentType(), image.getBytes());
		return newsImage;
	}

	public List<News> getNews() {
		return newsRepository.findAll();
	}

	public Page<News> getLatestNews(Pageable pageable) {
        return newsRepository.findAll(pageable);
    }

	public void deleteAll() {
			newsRepository.deleteAll();
		
	}
}
