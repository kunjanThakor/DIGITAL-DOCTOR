package com.globtechpower.globtpfapidata.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.globtechpower.globtpfapidata.model.News;
import com.globtechpower.globtpfapidata.service.NewsServices;

@RestController
@RequestMapping("/sec")
@CrossOrigin(origins = "*")
public class NewsController {
	
	@Autowired
	NewsServices newsServices;
	
	@PostMapping(value ={"/uploadnews"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public News uploadNews(@RequestPart("news") News news, @RequestPart("image") MultipartFile image) throws IOException {
		return newsServices.uploadNews(news,image);
	}
	
	@GetMapping("/getnews")
	public List<News> getNews(){
		return newsServices.getNews();
	}
	
	  /*@GetMapping("/latest")
	    public ResponseEntity<Page<News>> getLatestNews(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "3") int size) {
	        Page<News> latestNews = newsServices.getLatestNews(PageRequest.of(page, size));
	        return new ResponseEntity<>(latestNews, HttpStatus.OK);
	    }*/
	
	 @GetMapping("/latest")
	    public ResponseEntity<Page<News>> getLatestNews(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
	        Page<News> latestNews = newsServices.getLatestNews(pageRequest);
	        return new ResponseEntity<>(latestNews, HttpStatus.OK);
	    }
	 
	 
	 @DeleteMapping("deleteAll")
	 public void deleteAll() {
		 newsServices.deleteAll();
	 }
	 
	 @GetMapping("/getbytitle")
	 public News getByTitle() {
		 return null;
	 }
	
}
