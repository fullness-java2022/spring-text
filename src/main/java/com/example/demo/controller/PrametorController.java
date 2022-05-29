package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("param")
@Controller
public class PrametorController {
	@GetMapping
	public String form() {
		return "param/form";
	}
	@PostMapping("confirm")
	public String confirm(
			@RequestParam String itemName, 
			@RequestParam Integer itemPrice,
			Model model
	) {
		System.out.println("itemName:"+itemName);
		System.out.println("itemPrice:"+itemPrice);
		model.addAttribute("itemName", itemName);
		model.addAttribute("itemPrice", itemPrice);
		return "param/confirm";
	}
}
