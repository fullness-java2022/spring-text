package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("practice01")
@Controller
public class Practice01Controller {
	@GetMapping
    public String home(){
        return "practice01/home";
    }
    @GetMapping("forward")
    public String forward(){
        return "practice01/first";
    }
    @GetMapping("second")
    public String second(){
        return "practice01/second";
    }
    @GetMapping("redirect")
    public String redirect(){
        return "redirect:/practice01/third";
    }
    @GetMapping("third")
    public String third(){
        return "practice01/third";
    }
}
