package com.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
	
	@GetMapping("/")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/SignUp")
	public String log() {
		return "/SignUp/log";
	}
}
