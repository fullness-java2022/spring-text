package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.ItemForm;

@RequestMapping("form")
@Controller
public class FormController {
	@ModelAttribute("itemForm")
	public ItemForm setupForm() {
		return new ItemForm();
	}
	@GetMapping("input")
	public String input() {
		return "form/input";
	}
	@PostMapping("confirm")
	public String confirm(@ModelAttribute("itemForm") ItemForm itemForm, Model model) {
		System.out.println("itemForm:"+itemForm);
		model.addAttribute("itemForm",itemForm);
		return "form/confirm";
	}
}
