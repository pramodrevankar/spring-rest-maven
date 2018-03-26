package com.papi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
//	@RequestMapping("/")
//	public String welcome() {
//		return "Welcome to Home Page.";
//	}
//	@RequestMapping("*")
//	public String welcome1() {
//		return "Welcome HomePage fallback section.";
//	}
	@RequestMapping()
	public String welcome2() {
		return "Welcome to HomePage Default section.";
	}
}
