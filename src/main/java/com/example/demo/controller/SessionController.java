package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.form.ItemForm;
import com.example.demo.form.ItemFormValidator;
import com.example.demo.repository.ItemCategoryRepository;

@SessionAttributes({"itemForm","categoryList"})
@RequestMapping("session")
@Controller
public class SessionController {
	
	@Autowired private ItemCategoryRepository repository;
	@Autowired private ItemFormValidator validator;
	
	@ModelAttribute("itemForm")
	public ItemForm setup() {
		return new ItemForm();
	}
	@InitBinder("itemForm")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validator);
	}
	@GetMapping("form")
	public String form(Model model) {
		model.addAttribute("categoryList", repository.selectAll());
		return "session/form";
	}
	@PostMapping("confirm")
	public String confirm(@Validated @ModelAttribute ItemForm itemForm, BindingResult bindingResult) {
		System.out.println("itemform"+itemForm);
		if(bindingResult.hasErrors()) return "session/form";
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
