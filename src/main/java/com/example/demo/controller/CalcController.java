package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.CalcForm;

@Controller
@RequestMapping("calc")
public class CalcController {
	@ModelAttribute
	public CalcForm setupForm() {
		return new CalcForm();
	}

	@GetMapping
	public String enter() {
		return "calc/enter";
	}

	@PostMapping
	public String result(@Validated CalcForm form, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("calcForm",form);
			return "calc/enter";
		}
		Integer result = form.getValue1()+form.getValue2();
		model.addAttribute("result",result);
		return "calc/result";
	}

}
