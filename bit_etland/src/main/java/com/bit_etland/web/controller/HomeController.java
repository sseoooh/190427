package com.bit_etland.web.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	public String home(HttpSession session,
			HttpServletRequest request) {
			
		logger.info("HomeController진입");
		System.out.println("홈컨트롤러 진입");
		session.setAttribute("time", new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(new Date()));
		
				return "index";
		
	}
	
}