package com.saivy.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.saivy.beans.FormObject;

@Controller
public class HomeController {
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@GetMapping("/")
	public String add(Model model) {
		model.addAttribute("formObject",new FormObject());
		return "index";
		
	}
	
	@PostMapping("/processContactRequest")
	public String process(@Valid FormObject formObject,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return "index";
		}
		else {
			System.out.println("IN add method : " +formObject.getEmail());
			System.out.print("mesggage " +formObject.getMessage());
			System.out.print("mesggage " +formObject.getName());
			SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo("Gursimarhehar@gmail.com");
	        msg.setSubject("Contacted From Portfolio"+" , " + formObject.getEmail());
	        msg.setText(formObject.getMessage());
	        javaMailSender.send(msg);  
			model.addAttribute("Success","Email Sent Successfully..");
	        return "index";	
		}
	}
	
}
