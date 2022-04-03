package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloController {
	@GetMapping
	public String hello() {
		return "hello/hello";
	}
	@PostMapping
	public String post() {
		return "redirect:/hello/redirect";
	}
	@GetMapping("redirect")
	public String redirect() {
		return "hello/redirect";
	}
}
