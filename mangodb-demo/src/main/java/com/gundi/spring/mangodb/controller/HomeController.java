package com.gundi.spring.mangodb.controller;

import com.gundi.spring.mangodb.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private PostService postService;
	
	@Autowired
	public HomeController(PostService postService){
		this.postService = postService;
	}
	
	@RequestMapping("/")
	public String home(){
		return postService.getLatestPost().toString();

	}
	
}
