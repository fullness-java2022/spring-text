package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("param")
@Controller
public class PrametorController {
	@GetMapping
	public String form() {
		return "param/form";
	}
}
