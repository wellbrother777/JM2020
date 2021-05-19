package com.example.spring.springboot.springboot_crude.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HelloController {

	@GetMapping(value = "/")
	public String homePage() {
		return "login";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
}