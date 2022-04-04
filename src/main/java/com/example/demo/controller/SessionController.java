package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.form.ItemForm;

@SessionAttributes("itemForm")
@RequestMapping("session")
@Controller
public class SessionController {
	@ModelAttribute("itemForm")
	public ItemForm setup() {
		return new ItemForm();
	}
	@GetMapping("form")
	public String form() {
		return "session/form";
	}
	@PostMapping("confirm")
	public String confirm(@ModelAttribute ItemForm itemForm) {
		System.out.println("itemform"+itemForm);
		return "session/confirm";
	}
	@PostMapping("execute")
	public String execute(@ModelAttribute ItemForm itemForm, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("itemForm",itemForm);
		return "redirect:/session/complete";
	}
	@GetMapping("complete")
	public String complete(@ModelAttribute ItemForm itemForm, Model model, SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "session/complete";
	}
}
